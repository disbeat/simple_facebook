import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JImage extends JLabel {
	private static final long serialVersionUID = 1088146978964054867L;
	
	ImageIcon icon = null;
	public JImage(ImageIcon icon) {
		super(icon);
		this.icon = icon;
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), icon.getImageObserver());
	}
}
