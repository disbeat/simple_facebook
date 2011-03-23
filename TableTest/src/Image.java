import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Image {
	public static Random rnd = new Random();

	public static void main(String[] args) throws MalformedURLException {
		String url = "http://babesmedia.entertainment.ign.com/babes/image/article/611/611746/ign-e3-babe-of-the-day-alexia-lei-20050510050133547-000.jpg";
		JImage lbl = new JImage(new ImageIcon(new URL(url)));
		lbl.setName("image");
		
		JFrame frame = new JFrame("test");
		frame.setContentPane(lbl);
		frame.setSize(250, 250);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
