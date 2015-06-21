package Knapsack;

import java.util.ArrayList;

/**
 * 
 * Includes the lists for trunks
 * 
 * @author Rune Krauss
 * 
 */
public class ItemList {
	/**
	 * Arraylist for trunks
	 */
	private ArrayList<Item> itemList;

	/**
	 * Initialized the arraylist
	 */
	public ItemList() {
		itemList = new ArrayList<Item>();
	}

	/**
	 * Adds the respective objects to the arraylist
	 * 
	 * @param suitcase
	 *            One suitcase in the respective trunk
	 */
	public void add(Item suitcase) {
		itemList.add(suitcase);
	}

	/**
	 * Calculate the sum (value) of the list
	 * 
	 * @return Sum of all values in the list
	 */
	public int valueSum() {
		int sum = 0;
		for (Item item : itemList) {
			sum += item.getValue();
		}
		return sum;
	}

	/**
	 * Calculate the sum (weight) of the list
	 * 
	 * @return Sum of all weights in the list
	 */
	public int weightSum() {
		int sum = 0;
		for (Item item : itemList) {
			sum += item.getWeight();
		}
		return sum;
	}

	/**
	 * Cast the list to a string
	 */
	public String toString() {
		String value = new String();
		for (Item item : itemList) {
			value += item.toString() + "<br>";
		}
		return value;
	}
}