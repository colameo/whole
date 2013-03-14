/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.e4.ui.menu;

import static org.whole.lang.e4.ui.api.IUIConstants.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.actions.AbstractCompositeContributionItem;
import org.whole.lang.e4.ui.actions.ActionRegistry;
import org.whole.lang.e4.ui.actions.IUpdatableAction;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.factories.QueriesEntityFactory;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.resources.IResourceRegistry;
import org.whole.lang.ui.actions.AssignableToPredicate;
import org.whole.lang.ui.actions.EnablerPredicateFactory;
import org.whole.lang.ui.actions.IEnablerPredicate;
import org.whole.lang.ui.editor.IGEFEditorKit;
import org.whole.lang.ui.menu.ActionContainer;
import org.whole.lang.ui.menu.ActionSet;
import org.whole.lang.ui.menu.FullMenuNameStrategy;
import org.whole.lang.ui.menu.HierarchicalFillMenuStrategy;
import org.whole.lang.ui.menu.IItemContainer;
import org.whole.lang.ui.menu.MenuManagerSet;
import org.whole.lang.util.DefaultWrapInTransformer;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.IEntityTransformer;
import org.whole.lang.util.ResourceUtils;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public class EntityAssistCompositeContributionItem extends AbstractCompositeContributionItem {
	protected ImageDescriptor languageIcon;

	public EntityAssistCompositeContributionItem(IEclipseContext context, ActionRegistry actionRegistry) {
		super(context, actionRegistry);
		try {
			this.languageIcon = ImageDescriptor.createFromURL(new URL(SELECT_LANGUAGE_ICON_URI));
		} catch (MalformedURLException e) {
		}
	}

	protected IContributionItem[] getItems() {
		List<IContributionItem> items = new ArrayList<IContributionItem>();
		
		Object selection = context.get(ESelectionService.class).getSelection();
		if (!(selection instanceof IBindingManager))
			return new IContributionItem[0];
		else {
			fillItems(MenuManagerListContainer.create(items), ActionListContainer.create(items), (IBindingManager) selection);
			return items.toArray(new IContributionItem[items.size()]);
		}
	}

	protected boolean fillItems(IItemContainer<MenuManager, ImageDescriptor> menuContainer, IItemContainer<IAction, ImageDescriptor> actionContainer, IBindingManager bm) {
		IEntity selectedEntity = bm.wGet("primarySelectedEntity");
		boolean hasExtendedActions = fillExtendedEntityAssistMenu(menuContainer, selectedEntity);

		actionContainer.addSeparator(true);

		boolean hasActions = fillEntityAssistMenu(actionContainer, selectedEntity, selectedEntity.wGetLanguageKit());
		
		return hasExtendedActions || hasActions;
	}

	protected boolean fillExtendedEntityAssistMenu(IItemContainer<MenuManager, ImageDescriptor> container, IEntity selectedEntity) {
		ILanguageKit selectedEntityLanguageKit = selectedEntity.wGetLanguageKit();
		List<MenuManager> menus = new ArrayList<MenuManager>();
		IResourceRegistry<ILanguageKit> registry = ReflectionFactory.getLanguageKitRegistry();
		for (ILanguageKit languageKit : registry.getResources(false, ResourceUtils.SIMPLE_COMPARATOR)) {
			if (languageKit.equals(selectedEntityLanguageKit))
				continue;
			String label = ResourceUtils.SIMPLE_NAME_PROVIDER.toString(registry, languageKit);
			MenuManager languageMenu = new MenuManager(label, languageIcon, null);
			if (fillEntityAssistMenu(ActionContainer.create(languageMenu), selectedEntity, languageKit))
				menus.add(languageMenu);
		}
		HierarchicalFillMenuStrategy.instance(FullMenuNameStrategy.instance())
				.fillMenu(container,
						MenuManagerSet.create(menus.toArray(new MenuManager[menus.size()])), 0, menus.size());

		return menus.size() > 0;
	}

	protected boolean fillEntityAssistMenu(IItemContainer<IAction, ImageDescriptor> container, IEntity selectedEntity, ILanguageKit lk) {
		boolean hasActions = false;

		final IEntity targetEntity = getTargetEntity(selectedEntity).wGetAdaptee(false);
		if (EntityUtils.isComposite(targetEntity)) {
			List<IAction> addActions = new ArrayList<IAction>();

			EntityDescriptor<?> componentEntityDescriptor = targetEntity.wGetEntityDescriptor(0);
			for (EntityDescriptor<?> ed : lk.getEntityDescriptorEnum()
					.getExtendedLanguageConcreteSubtypesOf(componentEntityDescriptor))
				addActions.add(getAddEntityAction(ed));
	
			Collections.sort(addActions, comparator);
			HierarchicalFillMenuStrategy.instance().fillMenu(
					container, ActionSet.create(addActions.toArray(new IAction[0])), 0, addActions.size());
	
			hasActions |= addActions.size() > 0;
		}

		List<IAction> replaceElements = new ArrayList<IAction>();

		EntityDescriptor<?> formalEntityDescriptor = EntityUtils.getFormalEntityDescriptor(targetEntity);
		for (EntityDescriptor<?> ed : lk.getEntityDescriptorEnum()
				.getExtendedLanguageConcreteSubtypesOf(formalEntityDescriptor))
			if (!ed.equals(targetEntity.wGetEntityDescriptor()))
				replaceElements.add(getReplaceEntityAction(ed));

		container.addSeparator(true);
		Collections.sort(replaceElements, comparator);
		HierarchicalFillMenuStrategy.instance().fillMenu(
				container, ActionSet.create(replaceElements.toArray(new IAction[0])), 0, replaceElements.size());
	
		hasActions |= replaceElements.size() > 0;

		List<IAction> wrapElements = new ArrayList<IAction>();

		Set<EntityDescriptor<?>> wrapTypes = new HashSet<EntityDescriptor<?>>();
		if (targetEntity.wGetLanguageKit().equals(lk) || EntityUtils.isResolver(targetEntity)) {

			IGEFEditorKit editorKit = (IGEFEditorKit) (targetEntity.wGetLanguageKit().equals(lk) ?
					ReflectionFactory.getEditorKit(targetEntity) : lk.getDefaultEditorKit());

			for (Object[] wrapAction : editorKit.getActionFactory().wrapActions()) {
				EntityDescriptor<?> ed = (EntityDescriptor<?>) wrapAction[1];
				if (isWrappable(targetEntity, ed, (IEnablerPredicate) wrapAction[0])) {
					String label = (String) wrapAction[2];
					IEntityTransformer transformer = (IEntityTransformer) wrapAction[3];
					wrapElements.add(actionRegistry.createPerformAction(label, WRAP_ICON_URI, 
							QueriesEntityFactory.instance.createBooleanLiteral(true), getBehavior(ed, transformer)));
					wrapTypes.add(ed);
				}
			}
		}

		for (EntityDescriptor<?> ed : lk.getEntityDescriptorEnum())
			if (EntityUtils.isComposite(ed) && !wrapTypes.contains(ed) &&
					isWrappable(targetEntity, ed, EnablerPredicateFactory.instance.alwaysTrue())) {
				String label = StringUtils.camelCaseToSpacedWords(ed.getName());
				wrapElements.add(actionRegistry.createPerformAction(label, WRAP_ICON_URI, 
						QueriesEntityFactory.instance.createBooleanLiteral(true), getBehavior(ed, DefaultWrapInTransformer.instance)));
			}

		container.addSeparator(true);
		Collections.sort(wrapElements, comparator);
		HierarchicalFillMenuStrategy.instance().fillMenu(
				container, ActionSet.create(wrapElements.toArray(new IAction[0])), 0, wrapElements.size());

		hasActions |= wrapElements.size() > 0;
		
		//TODO add text actions

		return hasActions;
	}

	protected IEntity getTargetEntity(IEntity selectedEntity) {
		return selectedEntity;
	}

	protected boolean isWrappable(IEntity selectedEntity, EntityDescriptor<?> ed, IEnablerPredicate predicate) {
		return (predicate == EnablerPredicateFactory.instance.alwaysTrue() ||
				((AssignableToPredicate) predicate).getEntityDescriptor()
						.isPlatformSupertypeOf(selectedEntity.wGetEntityDescriptor())) && EntityUtils.isReplaceable(selectedEntity, ed);
	}

	protected IUpdatableAction getAddEntityAction(EntityDescriptor<?> ed) {
		return actionRegistry.getAddEntityAction(ed);
	}
	protected IUpdatableAction getReplaceEntityAction(EntityDescriptor<?> ed) {
		return actionRegistry.getReplaceEntityAction(ed);
	}
	protected IEntity getBehavior(EntityDescriptor<?> ed, IEntityTransformer transformer) {
		return E4Utils.wrapToBehavior(ed, transformer);
	}
}
