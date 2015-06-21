package Presentation;

import java.awt.EventQueue;
import java.io.IOException;

import Presentation.JFrame;

/**
 * 
 * Main class of the program, includes the main method for executing
 * 
 * @author Rune Krauss
 * 
 */
public class MoneyTransporter {

	/**
	 * Program starts here and interact with the user
	 * 
	 * @param args
	 *            Responsible for the command line
	 * @throws IOException
	 *             Responsible for catch input output exception
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame f = new JFrame();
					f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
