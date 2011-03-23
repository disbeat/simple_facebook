package utils;

import java.awt.Graphics;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JImage extends JLabel {
	private static final long serialVersionUID = 8337023074316774085L;
	ImageIcon icon = null;
	String url = null;

	public JImage(String url) {
		super();
		this.url = url;
	}

	public void load() {
		try {
			this.icon = new ImageIcon(new URL(url));
			setIcon(icon);
		} catch (MalformedURLException e) {
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (icon != null)
			g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), icon.getImageObserver());
		else
			super.paintComponent(g);
	}
}
