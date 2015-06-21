package Knapsack;

import java.util.HashSet;

/**
 * 
 * Includes the lists for trunks
 * 
 * @author Rune Krauss
 * 
 */
public class Matrix {
	/**
	 * Total weight of the elements
	 */
	private int totalWeight = 0;
	/**
	 * Array of all objects
	 */
	private Item[] allItems = {};
	/**
	 * Matrix
	 */
	private boolean[][] matrix = {};
	/**
	 * Pointer for the matrix
	 */
	private int[] pointer = { 0, 0 };

	/**
	 * Initialized the attributes and starts the partition
	 * 
	 * @param allItems
	 *            Array of the objects
	 */
	public Matrix(Item[] allItems) {
		this.allItems = allItems;
		for (int i = 0; i < allItems.length; i++) {
			totalWeight += allItems[i].getWeight();
		}
		matrix = new boolean[totalWeight / 2 + 1][allItems.length + 1]; // Create boolean matrix
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[0][i] = true;
		}
		pointer[0] = matrix.length - 1;
		pointer[1] = matrix[0].length - 1;
		this.partition(allItems);
	}

	/**
	 * Tracking, find out the boolean values regarding true and false.
	 * Furthermore, prints the matrix
	 * 
	 * @param allItems
	 *            Array of the objects
	 */
	private void partition(Item[] allItems) {
		for (int x = 1; x < matrix.length; x++) { // Decrements the weight/2+1
			for (int y = 1; y < matrix[0].length; y++) { // Decrements the objects+1
				int weight = allItems[y - 1].getWeight();
				if ((x - weight) >= 0) { // If a natural number set slot true
					matrix[x][y] = matrix[x][y - 1]
							|| matrix[x - weight][y - 1];
				}
			}
		}
//		System.out.println("Matrix is being partitioned...");
//		System.out.println();
//		for (int x = 0; x < matrix.length; x++) { // Increments the weight/2+1
//			for (int y = 0; y < matrix[0].length; y++) { // Increments the objects+1
//				if (matrix[x][y]) { // If a natural number echo 1 else 0
//					System.out.print("1 ");
//				} else {
//					System.out.print("0 ");
//				}
//			}
//			System.out.println();
//		}
//		System.out.println();
	}

	/**
	 * Backtracking, differentiates between true and false. It sets pointer and
	 * saves the values into a hashset.
	 * 
	 * @return Trunk, also the lists with objects
	 */
	public Trunk backTrack() {
		Trunk trunk = new Trunk(); // Create a trunk with responsive itemlist
		HashSet<Integer> hs = new HashSet<Integer>();
		while (!matrix[pointer[0]][pointer[1]]) { // Increments the matrix
			this.setPointer();
		}
		int x = pointer[0];
		int y = pointer[1];
		while (x > 0) {
			int weight = allItems[y - 1].getWeight();
			if (matrix[x - weight][y - 1]) { // If natural number add this slot the hashset
				hs.add(y - 1);
				x -= weight;
				y--;
			} else {
				y--;
			}
		}
		this.setPointer();
		for (int n = 0; n < allItems.length; n++) {
			if (hs.contains(n)) { // If natural number add this slot the leftTrunk else to the right trunk
				trunk.insertLeft(allItems[n]);
			} else {
				trunk.insertRight(allItems[n]);
			}
		}
		return trunk;
	}

	/**
	 * Sets pointers for the matrix
	 */
	private void setPointer() { // Decrements the weight/2+1 and objects+1
		int x = pointer[0];
		int y = pointer[1];
		if (y == 0) {
			y = matrix[0].length - 1;
			x = x - 1;
		} else {
			y = y - 1;
		}
		pointer[0] = x;
		pointer[1] = y;
	}

	/**
	 * Checks the left trunk for the solution
	 * 
	 * @return true if the pointers are positive, else false
	 */
	public boolean possibleSolutionLeft() {
		if (pointer[0] > 0 && pointer[1] > 0) {
			return true;
		} else {
			return false;
		}
	}
}