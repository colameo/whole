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
package org.whole.langs.legacy;

import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.reflect.AbstractDynamicLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.xml.codebase.XmlBuilderPersistenceKit;

/**
 * @author Enrico Persiani
 */
public class LegacyDynamicLanguagesDeployer extends AbstractDynamicLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		try {
			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/html/HTML5Model.xwl")));
			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/mediawiki/MediaWikiModel.xwl")));
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(LegacyMetaModelsDeployer.HTML5_URI);
	}
}
