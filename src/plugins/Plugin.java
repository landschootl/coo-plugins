package plugins;
/**
 * An interface Plugin which will be extended by all the plugins we are going to create
 * @author Coilliaux Thibault
 * @author Deleplanque Dylan
 * @author Lanschoot Ludovic
 * @author Saab Mathieu
 *
 */
public abstract interface Plugin {
	
	/**
	 * The transformation the plugin will apply to a text str
	 * @param str the text which will be transformed
	 * @return the transformed text
	 */
	public String transform(String str);
	/**
	 * A method which returns the label of the plugin
	 * @return the label of the plugin
	 */
	public String getLabel();
}
