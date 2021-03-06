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
package org.whole.lang.artifacts.codebase;

import org.whole.lang.artifacts.model.Workspace;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class JavaProjectTemplate extends AbstractTemplateFactory<Workspace> {


    public void apply(IBuilderOperation op) {
        org.whole.lang.artifacts.builders.IArtifactsBuilder b0 = (org.whole.lang.artifacts.builders.IArtifactsBuilder) op.wGetBuilder(org.whole.lang.artifacts.reflect.ArtifactsLanguageKit.URI);
        b0.Workspace_();
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.Projects_(1);
        b0.Project_();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/Artifacts#Name");
        b1.VarName("projectName");
        b1.Quantifier("MANDATORY");
        b1._Variable();
        b0.Natures_(1);
        b0.Nature("org.eclipse.jdt.core.javanature");
        b0._Natures();
        b1.Resolver();
        b0.Artifacts_(1);
        b0.FolderArtifact_();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/Artifacts#Name");
        b1.VarName("sourceFolderName");
        b1.Quantifier("MANDATORY");
        b1._Variable();
        b1.Resolver();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/Artifacts#Artifacts");
        b1.VarName("artifacts");
        b1.Quantifier("MANDATORY");
        b1._Variable();
        b0._FolderArtifact();
        b0._Artifacts();
        b0._Project();
        b0._Projects();
        b0._Workspace();
    }
}
