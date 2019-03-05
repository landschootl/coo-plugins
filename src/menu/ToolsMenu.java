package menu;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import plugins.Plugin;
import view.PluginFrame;

/**
 * ToolsMenu is a class which represents the menu of our main frame. It implements Observer because or each file we are goind to add or remove into the dropins directory, it will be updater
 * @author Coilliaux Thibault
 * @author Deleplanque Dylan
 * @author Landschoot Ludovic
 * @author Saab Mathieu
 */

public class ToolsMenu extends JMenu implements Observer {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Plugin> plugins;

	private PluginFrame pluginFrame;
	
	/**
	 * Constructor for the class
	 * @param pf The frame in which the menu will be added
	 */
	public ToolsMenu(PluginFrame pf) {
		super("t_Tools");
		plugins = new ArrayList<Plugin>();
		pluginFrame = pf;
	}

	/**
	 * A method which will update the Tools list which each file we are going to find in the dropins directory
	 * @param plugs the list of plugins we want to add
	 */
	@Override
	public void updatePluginList(ArrayList<Plugin> plugs) { // Bon là on recharge toute la liste, on leur remet une AbstractAction, c'est lourd.. Voir si on peut éviter en chargent tout ça plus tôt dans pluginfinder
		plugins = plugs;
		if(plugins == null || plugins.size() == 0)
			return;
		this.removeAll();
		
		for(Plugin p : plugins) {
			this.add(new JMenuItem(new AbstractAction(p.getLabel()) {

				/**
				 * 
				 */
				private static final long serialVersionUID = 5568457420899186726L;

				@Override
				public void actionPerformed(ActionEvent e) {
					String str;
					if(pluginFrame.getTextArea().getSelectedText() == null)
						str = pluginFrame.getTextArea().getText();
					else
						str = pluginFrame.getTextArea().getSelectedText();
					pluginFrame.setTextArea(p.transform(str));
				}
			}));
		}
	}
}
