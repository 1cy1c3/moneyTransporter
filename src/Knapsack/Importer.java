package Knapsack;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

/**
 * 
 * Imports the text file and prepare the document
 * 
 * @author Rune Krauss
 * 
 */
public class Importer {
	/**
	 * Path to the text file
	 */
	private String txtFile = "";
	/**
	 * Counts the elements of the text file
	 */
	private int counter = 0;
	/**
	 * Read in the text file
	 */
	private BufferedReader br;

	/**
	 * Initialized the path variable
	 * 
	 * @param txtFile
	 *            Name of the text file
	 */
	public Importer(String txtFile) {
		this.txtFile = txtFile;
	}

	/**
	 * Saves the data of the text lines in objects
	 * 
	 * @return All objects with the attributes weight and value
	 * @throws IOException
	 *             Responsible for catch input output exception
	 */
	public Item[] importTxtFile() throws IOException {
		FileReader fr = new FileReader(txtFile);
		br = new BufferedReader(fr);
		counter = Integer.parseInt(br.readLine().trim());
		Item[] allItems = new Item[counter];
		for (int i = 0; i < counter; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextElement().toString().trim());
			int weight = Integer.parseInt(st.nextElement().toString().trim());
			allItems[i] = new Item(weight, value);
		}
		return allItems;
	}
}