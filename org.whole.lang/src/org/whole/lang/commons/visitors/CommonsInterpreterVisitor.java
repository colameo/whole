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
package org.whole.lang.commons.visitors;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.model.BaseFragment;
import org.whole.lang.commons.model.InlineVariable;
import org.whole.lang.commons.model.Resolver;
import org.whole.lang.commons.model.RootFragment;
import org.whole.lang.commons.model.SameStageFragment;
import org.whole.lang.commons.model.StageDownFragment;
import org.whole.lang.commons.model.StageUpFragment;
import org.whole.lang.commons.model.TemplateFragment;
import org.whole.lang.commons.model.Variable;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.matchers.SubstituteException;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.IOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.BindingUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.MissingVariableException;
import org.whole.lang.visitors.VisitException;

/**
 * @author Riccardo Solmi
 */
public class CommonsInterpreterVisitor extends CommonsIdentityVisitor {
    @Override
	public void setResultIterator(IEntityIterator<?> iterator) {
		if (iterator != null)
			iterator.setBindings(getBindings());
		super.setResultIterator(iterator);
	}

	public void visit(RootFragment entity) {
		stagedVisit(entity.wGetRoot(), 0);
	}

	public void visit(SameStageFragment entity) {
		stagedVisit(entity.wGetRoot(), 0);
	}

	public void visit(StageDownFragment entity) {
		setResult(null);
		stagedVisit(entity.wGetRoot(), -1);
	}

	public void visit(StageUpFragment entity) {
		stagedVisit(entity.wGetRoot(), +1);

		if (isResultIterator()) {
			IEntityIterator<?> templateIterator = getResultIterator();
			setResultIterator(IteratorFactory.composeIterator(
					IteratorFactory.singleValuedRunnableIterator((IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
						if (!BindingManagerFactory.instance.isVoid(selfEntity))
							bm.setResult(EntityUtils.cloneIfParented(selfEntity));
					}).withSourceEntity(entity), templateIterator));
		} else {
			IEntity result = getResult();

			if (result!=null && EntityUtils.hasParent(result))
				setResult(EntityUtils.clone(result));
		}
	}

	@Override
	public void visit(BaseFragment entity) {
		stagedVisit(entity.wGetRoot(), -1,
				EntityUtils.safeStringValue(entity.wGet(CommonsFeatureDescriptorEnum.phase), null));
	}

	@Override
	public void visit(TemplateFragment entity) {
		stagedVisit(entity.wGetRoot(), +1,
				EntityUtils.safeStringValue(entity.wGet(CommonsFeatureDescriptorEnum.phase), null));
	}

	public void visit(Variable entity) {
		evaluate(entity, getBindings());
	}
	public void visit(InlineVariable entity) {
		evaluate(entity, getBindings());
	}
	public static final IEntity evaluate(Variable variable, IBindingManager bm) {
    	String varName = variable.getVarName().getValue();
    	IEntity value = BindingUtils.wGet(bm, varName);
		if (value != null) {
			if (Matcher.match(CommonsEntityDescriptorEnum.InlineVariable, variable)) {
				bm.setResultIterator(IteratorFactory.constantChildIterator(value));
				value = null;
			} else {
				EntityDescriptor<?> varType = variable.getVarType().getValue();
				try {
					bm.setResult(value = EntityUtils.convertCloneIfParented(value, varType));
				} catch (IllegalArgumentException e) {
					throw new SubstituteException(variable, value.wGetEntityDescriptor());					
				}
			}
			return value;
		} else
			throw new VisitException(new MissingVariableException(varName).withSourceEntity(variable).withBindings(bm));
	}

	@Override
	public void visit(Resolver entity) {
	}


	public boolean visitAdapter(IEntityAdapter entity) {
		return evaluateAdapter(entity, getOperation());
	}

	public static final boolean visitAdapter(IEntityAdapter entity, IOperation op) {
		IEntity adaptee = entity.wGetAdaptee(false);
		EntityDescriptor<?> adapteeEd = adaptee.wGetEntityDescriptor();

		if (entity.wGetEntityDescriptor().equals(adapteeEd))
			return true;
		else {
			op.stagedVisit(adaptee, 0);
			return false;
		}
	}
	public static final boolean evaluateAdapter(IEntityAdapter entity, IOperation op) {
		boolean result = visitAdapter(entity, op);

//FIXME workaround for accept(this) without getResult (replace with evaluate)
		if (!result && op != null)
			BehaviorUtils.evaluateResult(op.getOperationEnvironment());

		return result;
	}
}
