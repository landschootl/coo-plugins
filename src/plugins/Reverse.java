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
public class Reverse implements Plugin {

	/**
	 * The transformation we apply
	 * @return the string reversed
	 */
	@Override
	public String transform(String str) {
		StringBuilder lettersBuff = new StringBuilder(str);
		return lettersBuff.reverse().toString();
	}

	/**
	 * A method which returns the label of the plugin
	 * @return reverse, the label of the plugin
	 */
	@Override
	public String getLabel() {
		return "Reverse";
	}

}
