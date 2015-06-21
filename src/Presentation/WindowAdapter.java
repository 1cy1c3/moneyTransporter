package Presentation;

import java.awt.event.WindowEvent;

/**
 * Class for better controlling the window switches
 * 
 * @author Rune Krauss
 * 
 */
public class WindowAdapter extends java.awt.event.WindowAdapter {
	private JFrame frame = null;
	
	/**
	 * Initializes the current frame
	 * @param frame Current frame of the application
	 */
	public WindowAdapter(JFrame frame) {
		this.frame = frame;
	}
	
	public void windowActivated(WindowEvent e) {
		System.out.println("The application is activated...");
	}
	public void windowClosed(WindowEvent e) {
		System.out.println("The application was closed...");
	}
	public void windowClosing(WindowEvent e) {
		System.out.println("The application is closed...");
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent e) {
		System.out.println("The application has been disabled...");
	}
	public void windowDeiconified(WindowEvent e) {
		System.out.println("The application was minimized...");
	}
	public void windowIconified(WindowEvent e) {
		System.out.println("The application was maximized...");
	}
	public void windowOpened(WindowEvent e) {
		System.out.println("The application was opened...");
	}
}
