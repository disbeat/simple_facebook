import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TableTest {
	public static Random rnd = new Random();
	public static void createCell(JPanel parent, int row, int col, int span) {

		GridBagConstraints c = new GridBagConstraints();

		//c.anchor = GridBagConstraints.CENTER;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridx = col;
		c.gridy = row;
		c.gridwidth = span;
		c.fill = GridBagConstraints.BOTH;

		JPanel cell = new JPanel(new BorderLayout());
		JButton lbl = new JButton("Cell " + row + "_" + col);
		lbl.setBackground(new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));
		lbl.setOpaque(true);
		cell.add(lbl, BorderLayout.CENTER);

		parent.add(lbl, c);
	}

	public static void main(String[] args) {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.red);

		createCell(panel, 1, 1, 1);
		//createCell(panel, 1, 2, 1);

		JFrame frame = new JFrame("test");
		frame.setContentPane(panel);
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
