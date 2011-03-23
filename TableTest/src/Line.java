import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Line {
	public static Random rnd = new Random();

	public static void main(String[] args) {
		JPanel line = new JPanel();
		line.setLayout(new FlowLayout(FlowLayout.LEFT));
		line.setBackground(Color.red);

		for (int i = 0; i < 100; i++) {
			JLabel lbl = new JLabel("test");
			lbl.setBackground(new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));
			lbl.setOpaque(true);
			line.add(lbl);
		}

		JFrame frame = new JFrame("test");
		frame.setContentPane(line);
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
