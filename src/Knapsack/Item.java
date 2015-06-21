package Knapsack;

/**
 * 
 * Includes the attributes of the objects
 * 
 * @author Rune Krauss
 * 
 */
public class Item {
	/**
	 * Weight of an object
	 */
	private int weight = 0;
	/**
	 * value of an object
	 */
	private int value = 0;

	/**
	 * Initialized the character of an object
	 * 
	 * @param weight
	 *            Weight of an object
	 * @param value
	 *            value of an object
	 */
	public Item(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}

	/**
	 * Cast the object to a string
	 */
	public String toString() {
		return "Value: " + value + " Weight: " + weight;
	}

	/**
	 * Returns the weight of an object
	 * 
	 * @return Weight of an object
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Returns the value of an object
	 * 
	 * @return Value of an object
	 */
	public int getValue() {
		return value;
	}
}