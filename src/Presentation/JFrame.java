package Presentation;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import Knapsack.Importer;
import Knapsack.Matrix;
import Knapsack.Trunk;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

/**
 * Class for drawing the GUI and implementing application code/listener
 * methods
 * 
 * @author Rune Krauss
 * 
 */
public class JFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JButton btnStart;
	private JButton btnLoad;
	private JTextField txtFile;
	private File dir;
	private JTextField txtTime;
	private JEditorPane textArea;
	private int path = 0;

	/**
	 * Launch the application
	 */
	public JFrame() {
		drawGUI();
	}

	public JFrame(String title) {
		super(title);
	}

	private void exit() {
		int response = JOptionPane.showConfirmDialog(null,
				"Do you really want to exit?");
		if (response == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	private void about() {
		JOptionPane
				.showMessageDialog(
						this,
						"It's calculates the optimal allocation usage a value limit, for example 10.000.");
	}

	/**
	 * Draws the GUI
	 */
	private void drawGUI() {
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Money transporter");
		addWindowListener(new WindowAdapter(this));

		setSize(331, 350);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		mnFile.add(mntmExit);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmberEmailmanagement = new JMenuItem(
				"About money transporter");
		mntmberEmailmanagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				about();
			}
		});
		mnHelp.add(mntmberEmailmanagement);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		btnLoad = new JButton("Load file");
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLoad.setBounds(10, 10, 85, 35);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"Text", "txt");
				JFileChooser fC = new JFileChooser(new File("")
						.getAbsolutePath() + "/src/Assets");
				fC.setBounds(10, 10, 155, 135);
				fC.setFileFilter(filter);
				path = fC.showOpenDialog(null);
				if (path == JFileChooser.APPROVE_OPTION) {
					dir = fC.getCurrentDirectory();
					txtFile.setText(fC.getSelectedFile().getName());
				}
				repaint();
			}
		});
		contentPane.add(btnLoad);

		txtFile = new JTextField();
		txtFile.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFile.setBounds(100, 10, 100, 35);
		txtFile.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(txtFile);

		btnStart = new JButton("Start");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnStart.setBounds(10, 50, 55, 35);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					long timeStart = System.currentTimeMillis();
					Importer importer = new Importer(dir + "/" + txtFile.getText());
					Matrix moneyTransporter = null;
					try {
						moneyTransporter = new Matrix(importer.importTxtFile());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					Trunk trunk = moneyTransporter.backTrack();
					while (moneyTransporter.possibleSolutionLeft()) {
						if (trunk.valueDifference() < 10000) {
							break;
						}
						trunk = moneyTransporter.backTrack();
					}
					long timeEnd = System.currentTimeMillis();
					float timeTotal = (float) (timeEnd - timeStart) / 1000f;
					textArea.setText("<b>Left trunk:</b><br>"
							+ trunk.getLeft().toString()
							+ "<b>Right trunk:</b><br>"
							+ trunk.getRight().toString()
							+ "<b>Value difference:</b><br>"
							+ String.valueOf(trunk.valueDifference())
							+ "<br><b>Weight difference:</b><br>"
							+ String.valueOf(trunk.weightDifference()));
					txtTime.setText(String.valueOf(timeTotal));
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"An error has occurred!");
				}
			}
		});
		contentPane.add(btnStart);

		textArea = new JEditorPane("text/html", "");
		textArea.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 100, 311, 150);

		contentPane.add(scrollPane);

		JLabel lblTime = new JLabel("Time in s");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTime.setBounds(10, 260, 55, 35);
		contentPane.add(lblTime);

		txtTime = new JTextField();
		txtTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTime.setBounds(70, 260, 55, 35);
		txtTime.setEditable(false);
		txtTime.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(txtTime);
	}
}
