/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.reusables.visitors;

import static org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum.Expression_ord;
import static org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum.Reusable;
import static org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum.Reusable_ord;
import static org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum.Reusables;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.resources.CompoundResourceRegistry;
import org.whole.lang.resources.IResource;
import org.whole.lang.resources.IResourceRegistry;
import org.whole.lang.resources.ResourceRegistry;
import org.whole.lang.reusables.factories.ReusablesEntityFactory;
import org.whole.lang.reusables.model.Adapt;
import org.whole.lang.reusables.model.IReusablesEntity;
import org.whole.lang.reusables.model.Include;
import org.whole.lang.reusables.model.Model;
import org.whole.lang.reusables.model.Registry;
import org.whole.lang.reusables.model.Reusable;
import org.whole.lang.reusables.model.Reuse;
import org.whole.lang.reusables.model.Sync;
import org.whole.lang.reusables.operations.EvaluateCloneOperation;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Enrico Persiani
 */
public class ReusablesInterpreterVisitor extends AbstractReusablesSemanticsVisitor {
    @Override
	public void setResultIterator(IEntityIterator<?> iterator) {
		if (iterator != null)
			iterator.setBindings(getBindings());
		super.setResultIterator(iterator);
	}

    protected EvaluateCloneOperation evaluateCloneOperation;
    protected EvaluateCloneOperation getEvaluateCloneOperation() {
		if (evaluateCloneOperation == null) {
			evaluateCloneOperation = new EvaluateCloneOperation(getOperation(), entity -> Matcher.matchAnyImpl(entity,
					ReusablesEntityDescriptorEnum.Adapt, ReusablesEntityDescriptorEnum.Resource,
					ReusablesEntityDescriptorEnum.Include, ReusablesEntityDescriptorEnum.Reuse,
					ReusablesEntityDescriptorEnum.Sync));
		}
		return evaluateCloneOperation;
    }
   
    protected boolean isEvaluateCloneOperation() {
    	return getBindings().wIsSet("evaluateCloneOperation");
    }

    protected void evaluateAndClone(IEntity entity, IBindingManager bm) {
    	bm.setResult(getEvaluateCloneOperation().clone(entity));
    }
    protected void evaluateAndClone(IEntity entity) {
    	evaluateAndClone(entity, getBindings());
    }

    @Override
    public boolean visitAdapter(IEntityAdapter entity) {
    	setResult(null);

    	switch (entity.wGetEntityDescriptor().getOrdinal()) {

    	case Reusable_ord:
    		if (isEvaluateCloneOperation())
    			evaluateAndClone(entity.wGetAdaptee(false));
    		else
    			return super.visitAdapter(entity);
			return false;

		case Expression_ord:
//			setResultIterator(DynamicCompilerOperation.compile(entity.wGetAdaptee(false), getBindings()).getResultIterator());
			try {
				getBindings().wEnterScope();
				getBindings().wDef("self", entity.wGetAdaptee(false));
				setResultIterator(BehaviorUtils.lazyEvaluate(entity.wGetAdaptee(false), 0, getBindings()));
			} finally {
				getBindings().wExitScope();
			}
			return false;

		default:
			return super.visitAdapter(entity);
		}
    }

    @Override
    public void visit(IReusablesEntity entity) {
    	switch (entity.wGetEntityDescriptor().getOrdinal()) {
    	case ReusablesEntityDescriptorEnum.Load_ord:
    	case ReusablesEntityDescriptorEnum.Save_ord:
    	case ReusablesEntityDescriptorEnum.Classpath_ord:
    	case ReusablesEntityDescriptorEnum.FileSystem_ord:
    	case ReusablesEntityDescriptorEnum.Workspace_ord:
    	case ReusablesEntityDescriptorEnum.URL_ord:
    	case ReusablesEntityDescriptorEnum.File_ord:
    	case ReusablesEntityDescriptorEnum.PathSegments_ord:
    	case ReusablesEntityDescriptorEnum.PathWithExtension_ord:
    	case ReusablesEntityDescriptorEnum.PathName_ord:
    	case ReusablesEntityDescriptorEnum.PersistenceId_ord:
    	case ReusablesEntityDescriptorEnum.URI_ord:
    	case ReusablesEntityDescriptorEnum.Contents_ord:
    	case ReusablesEntityDescriptorEnum.Folder_ord:
    		DynamicCompilerOperation.compile(entity, getBindings());
    		return;
    	}

		if (isEvaluateCloneOperation())
			evaluateAndClone(entity);
    }

	@Override
	public void visit(Adapt entity) {
		Reusable reusable = entity.getAdapted();

		IEntityIterator<?> contentIterator = null;
		IEntityIterator<?> adapterIterator = null;
		if (EntityUtils.isResolver(reusable)) {
			contentIterator = IteratorFactory.constantIterator(entity.getOriginal(), false);

			if (EntityUtils.isNotResolver(entity.getAdapter())) {
				entity.getAdapter().accept(this);
				adapterIterator = getResultIterator();
			}
		}

		if (contentIterator == null)
			contentIterator = IteratorFactory.constantIterator(reusable, false);

		boolean updateAdapted = EntityUtils.isResolver(entity.getAdapted());
		IEntityIterator<?> evaluateIterator = IteratorFactory.singleValuedRunnableIterator(
			(selfEntity, bm, arguments) -> {
				try {
					getBindings().wEnterScope();
					getBindings().wDefValue("evaluateCloneOperation", true);
					evaluateAndClone(selfEntity, bm);
				} finally {
					getBindings().wExitScope();
				}
				if (updateAdapted) {
					Reusable adapted = EntityUtils.clone(bm.getResult()).wGetAdapter(Reusable);
					if (EntityUtils.isResolver(entity.getAdapted()))
						entity.setAdapted(adapted);
					else {
						if (!Matcher.matchImpl(Reusables, entity.getAdapted()))
							entity.setAdapted(ReusablesEntityFactory.instance.createReusables(EntityUtils.clone(entity.getAdapted())));
						entity.getAdapted().wAdd(adapted);
					}
				}
			}
		);

		IEntityIterator<? extends IEntity> expandIterator = adapterIterator != null ? 
				IteratorFactory.composeIterator(evaluateIterator, adapterIterator, contentIterator) :
					IteratorFactory.composeIterator(evaluateIterator, contentIterator);

		for (IEntity result : expandIterator) {
			stagedVisit(result.wGetAdaptee(false));
			setResult(result);
		}
	}

	@Override
	public void visit(Include entity) {
		IEntityIterator<?> contentIterator = readResource(entity.getResource());

		IEntityIterator<?> evaluateIterator = IteratorFactory.singleValuedRunnableIterator(
				(selfEntity, bm, arguments) -> evaluateAndClone(selfEntity, bm));
		setResultIterator(IteratorFactory.composeIterator(evaluateIterator, contentIterator));
	}

	@Override
	public void visit(Reuse entity) {
		Reusable reusable = entity.getAdapted();

		Reusable original = CommonsEntityAdapterFactory.createResolver(Reusable);

		IEntityIterator<?> contentIterator = null;
		IEntityIterator<?> adapterIterator = null;
		if (EntityUtils.isResolver(reusable)) {
			try {
				getBindings().wEnterScope();
				getBindings().wDefValue("evaluateCloneOperation", true);

				reusable =  entity.getOriginal();
	
				if (EntityUtils.isResolver(reusable)) {
					contentIterator = readResource(entity.getResource());
					contentIterator.setBindings(getBindings());
					contentIterator.reset(entity);
					if (contentIterator.hasNext())
						original = EntityUtils.clone(contentIterator.next()).wGetAdapter(Reusable);
					if (contentIterator.hasNext()) {
						original = ReusablesEntityFactory.instance.createReusables(original);
						do {
							original.wAdd(EntityUtils.clone(contentIterator.next()).wGetAdapter(Reusable));
						} while (contentIterator.hasNext());
					}
					entity.setOriginal(original);
				}
				if (EntityUtils.isNotResolver(entity.getAdapter())) {
					entity.getAdapter().accept(this);
					adapterIterator = getResultIterator();
				}
			} finally {
				getBindings().wExitScope();
			}
		}

		if (contentIterator == null)
			contentIterator = IteratorFactory.constantIterator(reusable, false);

		boolean updateAdapted = EntityUtils.isResolver(entity.getAdapted());
		IEntityIterator<?> evaluateIterator = IteratorFactory.singleValuedRunnableIterator(
			(selfEntity, bm, arguments) -> {
				try {
					getBindings().wEnterScope();
					getBindings().wDefValue("evaluateCloneOperation", true);
					evaluateAndClone(selfEntity, bm);
				} finally {
					getBindings().wExitScope();
				}
				if (updateAdapted) {
					Reusable adapted = EntityUtils.clone(bm.getResult()).wGetAdapter(Reusable);
					if (EntityUtils.isResolver(entity.getAdapted()))
						entity.setAdapted(adapted);
					else {
						if (!Matcher.matchImpl(Reusables, entity.getAdapted()))
							entity.setAdapted(ReusablesEntityFactory.instance.createReusables(EntityUtils.clone(entity.getAdapted())));
						entity.getAdapted().wAdd(adapted);
					}
				}
			}
		);

		setResultIterator(adapterIterator != null ? 
				IteratorFactory.composeIterator(evaluateIterator, adapterIterator, contentIterator) :
					IteratorFactory.composeIterator(evaluateIterator, contentIterator));
	}

	@Override
	public void visit(Sync entity) {
		Reusable reusable = entity.getVariant();

		if (EntityUtils.isResolver(reusable))
			visit((Reuse) entity);
		else {
			setResultIterator(IteratorFactory.constantComposeIterator(reusable,
					IteratorFactory.singleValuedRunnableIterator(
							(selfEntity, bm, arguments) -> evaluateAndClone(selfEntity, bm)
			)));
		}
	}

	@Override
	public void visit(Registry entity) {
		entity.getRegistryUri().accept(this);
		String registryId = getResult().wStringValue();
		if (!ResourceRegistry.hasRegistry(registryId))
			throw new WholeIllegalArgumentException("Undefined registry "+registryId).withSourceEntity(entity).withBindings(getBindings());

		IResourceRegistry<IResource> registry = ResourceRegistry.getRegistry(registryId);

		entity.getUri().accept(this);
		String uri = getResult().wStringValue();

		if (ResourceUtils.hasFragmentPart(uri) && registry instanceof CompoundResourceRegistry) {
			CompoundResourceRegistry<IResource> compoundRegistry = (CompoundResourceRegistry<IResource>) registry;
			setResult(compoundRegistry.getFunctionModel(uri, true, getBindings()));
		} else
			setResult(registry.getResourceModel(uri, true, getBindings()));
	}

	@Override
	public void visit(Model entity) {
		entity.getContent().accept(this);
	}
}
