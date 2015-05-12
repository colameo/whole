/**
 * Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.commons.ui.editpolicies;

import org.eclipse.gef.commands.Command;
import org.whole.lang.commons.model.VarType;
import org.whole.lang.model.IEntity;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.ui.editpolicies.DataEntityDirectEditPolicy;

/**
 * @author Riccardo Solmi
 */
public class VarTypeDirectEditPolicy extends DataEntityDirectEditPolicy {
	@Override
	protected Command getDirectEditCommand(IEntity hostEntity, String value, IDataTypeParser parser) {
		if (value.indexOf('#') == -1)
			value = ((VarType) hostEntity).getValue().getLanguageKit().getURI()+'#'+value; 
		return super.getDirectEditCommand(hostEntity, value, parser);
	}
}