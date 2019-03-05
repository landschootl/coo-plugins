package menu;
import java.util.ArrayList;

/**
 * Observable is a class which is used to use the Observable design pattern
 * @author Coilliaux Thibault
 * @author Deleplanque Dylan
 * @author Landschoot Ludovic
 * @author Saab Mathieu
 *
 */

public abstract class Observable {

	protected ArrayList<Observer> observers;
	
	/**
	 * The constructor of the class
	 */
	public Observable() {
		observers = new ArrayList<Observer>();
	}
	
	/**
	 * Method which is used to add an Observer to the observers list
	 * @param obs the Observer we want to add
	 */
	public void addObserver(Observer obs) {
		this.observers.add(obs);
	}
	
	/**
	 * Method which us used to remove an Observer to the observers list
	 * @param obs the Observer we want to remove
	 */
	public void removeObserver(Observer obs) {
		this.observers.remove(obs);
	}
	
	/**
	 * Once we need to update observers, we call this method
	 */
	public abstract void updateObservers();

}
