package menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.Timer;

import plugins.Plugin;
import finder.PluginFilter;


/**
 * PluginFinderObservable is a class which finds all plugins in a directory and add it to 
 * the droppins directory
 * It will be used by an extendable editor.
 * @author Coilliaux Thibault
 * @author Deleplanque Dylan
 * @author Landschoot Ludovic
 * @author Saab Mathieu
 */
public class PluginFinderObservable extends Observable {
	
	private File directory;
	private ArrayList<File> filesPlugins;
	private ArrayList<Plugin> plugins;
	private PluginFilter filter;
	private Timer timer;
	
	/**
	 * Constructor for a plugin finder
	 * We create a timer which will, each seconds, check if there were any changes in the plugin directory
	 * @param path the path to the directory where the plugins are
	 */
	public PluginFinderObservable(String path) {
		super();
		directory = new File(path);
		filesPlugins = new ArrayList<File>();
		plugins = new ArrayList<Plugin>();
		filter = new PluginFilter();
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<File> files = new ArrayList<File>();
				boolean modif;
				for(File tmp : directory.listFiles(filter))
					files.add(tmp);
				if(modif = !files.equals(filesPlugins))
					filesPlugins = files;
				if(modif)
					update();
			}
		});
	}
	
	/**
	 * A method which will initialize the timer and the observers
	 */
	public void init() {
		this.timer.start();
		this.updateObservers();
	}

	/**
	 * A method which will regenerate the plugins list and call the update of the observers. 
	 */
	public void update() {
		this.generatePlugins();
		this.updateObservers();
	}
	
	/**
	 * A method which will update the observers
	 * Here, it will update the plugins list of the frame
	 */
	@Override
	public void updateObservers() {
		for(Observer o : this.observers)
			o.updatePluginList(plugins);
	}
	
	/**
	 * A method which will generate plugins from the list of files we have intanciated sooner
	 */
	public void generatePlugins() {
		plugins.clear();
		for(File f : filesPlugins)
			plugins.add(this.generatePluginFromFile(f));		
	}
	
	/**
	 * A method which creates a plugin from a given file
	 * @param f the file which contains a class file which extends plugins
	 * @return the plugin contained in the class file
	 */
	public Plugin generatePluginFromFile(File f) {
		Class<? extends Plugin> pluginClass = null;
		try {
			pluginClass = (Class<? extends Plugin>) Class.forName("plugins." + f.getName().replaceFirst("\\.class$", ""));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			return pluginClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
