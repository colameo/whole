/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.tests.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.tests.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class ResultsAdapter extends AbstractEntityAdapter implements Results {
    private static final long serialVersionUID = 1;

    public ResultsAdapter(IEntity implementor) {
        super(implementor);
    }

    public ResultsAdapter() {
    }

    public void accept(ITestsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Results> wGetEntityDescriptor() {
        return TestsEntityDescriptorEnum.Results;
    }

    public IntLiteral getSuccesses() {
        return wGet(TestsFeatureDescriptorEnum.successes).wGetAdapter(TestsEntityDescriptorEnum.IntLiteral);
    }

    public void setSuccesses(IntLiteral successes) {
        wSet(TestsFeatureDescriptorEnum.successes, successes);
    }

    public IntLiteral getFailures() {
        return wGet(TestsFeatureDescriptorEnum.failures).wGetAdapter(TestsEntityDescriptorEnum.IntLiteral);
    }

    public void setFailures(IntLiteral failures) {
        wSet(TestsFeatureDescriptorEnum.failures, failures);
    }

    public IntLiteral getErrors() {
        return wGet(TestsFeatureDescriptorEnum.errors).wGetAdapter(TestsEntityDescriptorEnum.IntLiteral);
    }

    public void setErrors(IntLiteral errors) {
        wSet(TestsFeatureDescriptorEnum.errors, errors);
    }
}
