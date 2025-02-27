/*
 * This file is part of muCommander, http://www.mucommander.com
 *
 * muCommander is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * muCommander is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.mucommander.ui.popup;

import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.mucommander.commons.util.ui.helper.MenuToolkit;
import com.mucommander.desktop.ActionType;
import com.mucommander.ui.action.ActionManager;
import com.mucommander.ui.main.MainFrame;

/**
 * Abstract class for popup menus that display MuActions.
 * 
 * @author Maxence Bernard, Nicolas Rinaudo, Arik Hadas
 */
public abstract class MuActionsPopupMenu extends JPopupMenu {

	/** Parent MainFrame instance */
    private MainFrame mainFrame;
    
    public MuActionsPopupMenu(MainFrame mainFrame) {
    	this.mainFrame = mainFrame;
    }
    
    /**
     * Adds the MuAction denoted by the given ID to this popup menu, as a <code>JMenuItem</code>.
     * @param actionId action ID
     */
    protected JMenuItem addAction(String actionId) {
        return add(ActionManager.getActionInstance(actionId, mainFrame));
    }

    /**
     * @see #addAction(String)
     */
    protected JMenuItem addAction(ActionType actionType) {
        return addAction(actionType.toString());
    }
    
    @Override
    public final JMenuItem add(Action a) {
    	JMenuItem item = super.add(a);
    	MenuToolkit.configureActionMenuItem(item);
    	return item;
    }
}
