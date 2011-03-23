package clients.builder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import utils.JImage;

public class SwingBuilder extends HierarchicalBuilding<JComponent> implements InterfaceBuilder {
	HashMap<String, String> cookies = new HashMap<String, String>();
	String redirectPath = null;
	JPanel page = null;

	@Override
	public void setCookie(String name, String value) {
		cookies.put(name, value);
	}

	@Override
	public void setRedirect(String path) {
		this.redirectPath = path;
	}

	@Override
	public int createPage(String title, Style style) {
		page = new JPanel();
		page.setLayout(new BoxLayout(page, BoxLayout.Y_AXIS));
		page.setToolTipText(title);

		applyStyle(style, page, null);
		return putObject(page);
	}

	String maxTextWidth(int chars, String text) {
		String res = "<html>";
		for (int i = 0; i < text.length(); i++) {
			res = res + text.charAt(i);
			if (i > 0 && i % chars == 0)
				res = res + "<br />";
		}
		return res + "</html>";
	}

	void applyStyle(Style style, JComponent obj, JComponent parent) {
		if (style == null)
			return;

		if (style.border != -1)
			obj.setBorder(new LineBorder(style.borderColor, style.border));

		if (style.bgColor != null) {
			obj.setOpaque(true);
			obj.setBackground(style.bgColor);
		}

		obj.setFont(new Font(style.fontName, (style.fontBold) ? Font.BOLD : 0, style.fontSize));

		if (style.maxheight != -1 || style.maxwidth != -1) {
			// obj.setPreferredSize(new Dimension(style.maxwidth,
			// style.maxheight));
			// obj.setMaximumSize(new Dimension(style.maxwidth,
			// style.maxheight));
			if (obj instanceof JLabel) {
				JLabel lbl = (JLabel) obj;
				lbl.setText(maxTextWidth(style.maxwidth / 6, lbl.getText()));
			}
		}

		if (style.vertical) 
			obj.setLayout(new BoxLayout(obj, BoxLayout.Y_AXIS));
		else if (style.center)
			obj.setLayout(new BorderLayout());
		
		if (style.width == Integer.MAX_VALUE || style.height == Integer.MAX_VALUE)
			// if (parent != null)
			// parent.setLayout(new BorderLayout());
			;
		else if (style.width != -1 || style.height != -1)
			obj.setPreferredSize(new Dimension(style.width, style.height));

	}

	@Override
	public int createInput(int parent, String name, boolean isPassword, Style style) {

		JTextField txt = null;
		if (isPassword) {
			txt = new JPasswordField();
		} else {
			txt = new JTextField();
		}

		txt.setToolTipText(name);
		txt.setName(name);
		txt.setMinimumSize(new Dimension(250, 30));
		txt.setSize(new Dimension(250, 30));
		txt.setPreferredSize(new Dimension(250, 30));

		applyStyle(style, txt, getObject(parent));
		getObject(parent).add(txt);
		return putObject(txt);
	}

	@Override
	public int createButton(int parent, String name, String action, boolean forRoot, Style style) {
		JButton btn = new JButton(name);
		btn.setActionCommand(action);

		getObject(parent).add(btn);
		return putObject(btn);
	}

	@Override
	public int createFormButton(int parent, String label, Style style) {
		JButton btn = new JButton(label);
		btn.setActionCommand("submit");

		getObject(parent).add(btn);
		return putObject(btn);
	}

	@Override
	public int createForm(int parent, String name, String action, Style style) {
		JPanel formPanel = new JPanel();
		formPanel.setName("form" + name);
		formPanel.setToolTipText(action);
		formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

		applyStyle(style, formPanel, getObject(parent));
		getObject(parent).add(formPanel);
		return putObject(formPanel);
	}

	@Override
	public int createParagraph(int parent, Style style) {
		JPanel line = new JPanel();
		line.setLayout(new FlowLayout(FlowLayout.LEFT));

		JComponent parentObj = getObject(parent);
		applyStyle(style, line, parentObj);
		parentObj.add(line);
		return putObject(line);
	}

	@Override
	public int createFormHidden(int parent, String name, String value) {
		JTextField txt = new JTextField();
		txt.setToolTipText(name);
		txt.setName(name);
		txt.setText(value);
		txt.setVisible(false);

		getObject(parent).add(txt);
		return putObject(txt);
	}

	@Override
	public int createImage(int parent, String url, Style style) {
		JImage img = new JImage(url);

		JComponent parentObj = getObject(parent);
		applyStyle(style, img, parentObj);
		parentObj.add(img);

		return putObject(img);
	}

	@Override
	public int createExternalFrame(int parent, String action, boolean scrolling, Style style) {
		JScrollPane scroll = new JScrollPane();
		scroll.setName("frame");
		scroll.setToolTipText(action);
		// scroll.setMinimumSize(new Dimension(style.width, style.height));
		if (!scrolling) {
			scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		}

		JComponent parentObj = getObject(parent);
		applyStyle(style, scroll, parentObj);
		parentObj.add(scroll);

		return putObject(scroll);
	}

	@Override
	public int createText(int parent, String text, Style style) {
		JLabel txt = new JLabel(text);
		txt.setOpaque(false);

		JComponent parentObj = getObject(parent);
		applyStyle(style, txt, parentObj);
		parentObj.add(txt);

		return putObject(txt);
	}

	@Override
	public int createEmbed(int parent, String url, Style style) {
		return createImage(parent, "http://www.youtube.com/img/customize_player/preview_embed_iceberg_sm_nb.gif", style);
	}

	@Override
	public int createTable(int parent, int rows, int cols, Style style) {
		JPanel panel = new JPanel(new GridBagLayout());

		JComponent parentObj = getObject(parent);
		applyStyle(style, panel, parentObj);
		parentObj.add(panel);
		return putObject(panel);
	}

	@Override
	public int createCell(int parent, int row, int col, int span, Style style) {

		GridBagConstraints c = new GridBagConstraints();

		c.gridx = col;
		c.gridy = row;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridwidth = span;
		c.fill = GridBagConstraints.BOTH;

		JPanel cell = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JComponent parentObj = getObject(parent);
		applyStyle(style, cell, parentObj);
		parentObj.add(cell, c);

		return putObject(cell);
	}

	String cName(Object o) {
		if (o == null)
			return "";
		else
			return o.getClass().getSimpleName();
	}

	void printTree(int level, JComponent obj) {
		if (obj == null)
			return;

		for (int i = 0; i < level; i++)
			System.out.print("\t");

		String c = "";
		if (obj.getParent() != null) {
			LayoutManager l = obj.getParent().getLayout();
			if (l != null && l instanceof GridBagLayout) {
				GridBagConstraints con = ((GridBagLayout) l).getConstraints(obj);
				c = con.gridx + " x " + con.gridy;
			}
		}
		String name = (obj.getName() == null) ? "" : obj.getName() + ", ";
		String vis = (obj.isVisible() ? "showing" : "not showing");
		System.out.println(name + "" + cName(obj) + ", layout: " + cName(obj.getLayout()) + ", pos: " + c + " " + vis);

		for (int i = 0; i < obj.getComponentCount(); i++)
			printTree(level + 1, (JComponent) obj.getComponent(i));
	}

	@Override
	public BuilderResult getResult() {
		//printTree(0, page);
		return new BuilderResult(page, redirectPath, cookies);
	}
}
