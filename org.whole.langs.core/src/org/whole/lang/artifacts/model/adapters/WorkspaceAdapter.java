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
package org.whole.lang.artifacts.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class WorkspaceAdapter extends AbstractEntityAdapter implements Workspace {
    private static final long serialVersionUID = 1;

    public WorkspaceAdapter(IEntity implementor) {
        super(implementor);
    }

    public WorkspaceAdapter() {
    }

    public void accept(IArtifactsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Workspace> wGetEntityDescriptor() {
        return ArtifactsEntityDescriptorEnum.Workspace;
    }

    public Metadata getMetadata() {
        return wGet(ArtifactsFeatureDescriptorEnum.metadata).wGetAdapter(ArtifactsEntityDescriptorEnum.Metadata);
    }

    public void setMetadata(Metadata metadata) {
        wSet(ArtifactsFeatureDescriptorEnum.metadata, metadata);
    }

    public Projects getProjects() {
        return wGet(ArtifactsFeatureDescriptorEnum.projects).wGetAdapter(ArtifactsEntityDescriptorEnum.Projects);
    }

    public void setProjects(Projects projects) {
        wSet(ArtifactsFeatureDescriptorEnum.projects, projects);
    }
}
