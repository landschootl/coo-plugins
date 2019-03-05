package plugins;

/**
 * A plugin class.
 * This one will reverse the text we give it
 * @author Coilliaux Thibault
 * @author Deleplanque Dylan
 * @author Lanschoot Ludovic
 * @author Saab Mathieu
 *
 */
public class ToUpperCase implements Plugin {

	/**
	 * The transformation we apply
	 * @return the string to upper case
	 */
	@Override
	public String transform(String str) {
		if(str != null)
			return str.toUpperCase();
		return null;
	}

	/**
	 * A method which returns the label of the plugin
	 * @return reverse, the label of the plugin
	 */
	@Override
	public String getLabel() {
		return "To Upper Case";
	}

	
}
