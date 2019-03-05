package finder;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;

import plugins.Plugin;


/**
 * PluginFilter is a class which filter the plugins in a directory.
 * It has methods which will allow us to filter names of the files in a directory 
 * @author Coilliaux Thibault
 * @author Deleplanque Dylan
 * @author Landschoot Ludovic
 * @author Saab Mathieu
 * @implements FilenameFilter
 *
 */

public class PluginFilter implements FilenameFilter {

	/**
	 * A method which filter plugin files
	 * @param f the file we want to test
	 * @param name the name of the file 
	 */
	public boolean accept(File f, String name) {
		if(!isClassExtension(name))
			return false;
		Class<?> cls = null;
		try {
			cls = Class.forName("plugins." + name.replaceFirst("\\.class$", ""));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(cls == null)
			return false;
		
	    return (this.implementsPlugin(cls) && this.isFromPackagePlugins(cls) && this.hasConstructorNoParam(cls));
	}
	
	/**
	 * A method which test if the name passed in the parameters is the name of a class file
	 * @param name the name we want to test
	 * @return true if the name ends with .class
	 */
	public boolean isClassExtension(String name) {
		return name.endsWith(".class");
	}
	
	/**
	 * A method which returns true if the class we give in the parameters is the implementation of a plugin 
	 * @param cls the class we want to test
	 * @return true if the class is a Plugin
	 */
	public boolean implementsPlugin(Class<?> cls) {
		return Plugin.class.isAssignableFrom(cls);
	}
	
	/**
	 * A method which returns true if the class given in the parameters is from the plugins package
	 * @param cls the class we want to test
	 * @return true if the class is from package plugins
	 */
	public boolean isFromPackagePlugins(Class<?> cls) {
		return cls.getPackage().getName().equals("plugins");
	}
	
	/**
	 * A method which returns true if the class given in the parameters has at least one constructor without parameters
	 * @param cls the class we want to test
	 * @return true if the class has at least one constructor without parameters
	 */
	public boolean hasConstructorNoParam(Class<?> cls) {
		for(Constructor<?> c : cls.getConstructors())
			if(c.getParameters().length == 0)
				return true;
		return false;
	}

}
