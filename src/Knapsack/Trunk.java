package Knapsack;

/**
 * 
 * Includes the lists for trunks
 * 
 * @author Rune Krauss
 * 
 */
public class Trunk {
	/**
	 * List of the left trunk
	 */
	private ItemList leftTrunk;
	/**
	 * List of the right trunk
	 */
	private ItemList rightTrunk;

	/**
	 * Initialized the trunks
	 */
	public Trunk() {
		leftTrunk = new ItemList();
		rightTrunk = new ItemList();
	}

	/**
	 * Adds an object in the list to the left trunk
	 * 
	 * @param item
	 *            Object with the attributes weight and value
	 */
	public void insertLeft(Item item) {
		leftTrunk.add(item);
	}

	/**
	 * Adds an object in the list to the right trunk
	 * 
	 * @param item
	 *            Object with the attributes weight and value
	 */
	public void insertRight(Item item) {
		rightTrunk.add(item);
	}

	/**
	 * Returns the left trunk
	 * 
	 * @return Left trunk
	 */
	public ItemList getLeft() {
		return leftTrunk;
	}

	/**
	 * Returns the right trunk
	 * 
	 * @return Right trunk
	 */
	public ItemList getRight() {
		return rightTrunk;
	}

	/**
	 * Calculate the weight difference between left and right trunk
	 * 
	 * @return Weight difference
	 */
	public int weightDifference() {
		return Math.abs(leftTrunk.weightSum() - rightTrunk.weightSum());
	}

	/**
	 * Calculate the value difference between left and right trunk
	 * 
	 * @return Value difference
	 */
	public int valueDifference() {
		return Math.abs(leftTrunk.valueSum() - rightTrunk.valueSum());
	}
}