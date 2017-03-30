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
public class FilterFamilyAdapter extends AbstractEntityAdapter implements FilterFamily {
    private static final long serialVersionUID = 1;

    public FilterFamilyAdapter(IEntity implementor) {
        super(implementor);
    }

    public FilterFamilyAdapter() {
    }

    public void accept(ITestsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<FilterFamily> wGetEntityDescriptor() {
        return TestsEntityDescriptorEnum.FilterFamily;
    }

    public PackageName getPackageName() {
        return wGet(TestsFeatureDescriptorEnum.packageName).wGetAdapter(TestsEntityDescriptorEnum.PackageName);
    }

    public void setPackageName(PackageName packageName) {
        wSet(TestsFeatureDescriptorEnum.packageName, packageName);
    }

    public Description getDescription() {
        return wGet(TestsFeatureDescriptorEnum.description).wGetAdapter(TestsEntityDescriptorEnum.Description);
    }

    public void setDescription(Description description) {
        wSet(TestsFeatureDescriptorEnum.description, description);
    }

    public Name getName() {
        return wGet(TestsFeatureDescriptorEnum.name).wGetAdapter(TestsEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(TestsFeatureDescriptorEnum.name, name);
    }

    public FilterRules getFilterRules() {
        return wGet(TestsFeatureDescriptorEnum.filterRules).wGetAdapter(TestsEntityDescriptorEnum.FilterRules);
    }

    public void setFilterRules(FilterRules filterRules) {
        wSet(TestsFeatureDescriptorEnum.filterRules, filterRules);
    }
}
