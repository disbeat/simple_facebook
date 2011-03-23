package swing_app;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import utils.Config;
import utils.HTTPUtils;
import utils.JImage;
import views.markup.Button;
import clients.ClientRequest;
import clients.builder.BuilderResult;

public class SwingApp implements ActionListener {
	static Socket socket = null;
	static ObjectInputStream ois = null;
	static ObjectOutputStream oos = null;
	static HashMap<String, String> cookies = new HashMap<String, String>();

	JFrame frame = null;

	public static void main(String[] args) throws IOException {
		Config.loadSettings();

		// TODO: Testing purpose. Uncomment if needed.
		// cookies.put("userid", "3006");

		if (!connect())
			JOptionPane.showMessageDialog(null, "Error connecting to SimpleFacebook server... ", "Error", JOptionPane.ERROR_MESSAGE);
		else
			new SwingApp("/"); // can change root page to friends?uid=3006
	}

	public static boolean connect() {
		try {
			socket = new Socket(Config.getString("SERVER_HOST"), Config.getInt("SWING_PORT"));

			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.flush();
			ois = new ObjectInputStream(socket.getInputStream());

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public SwingApp(String root) {
		frame = new JFrame("SimpleFacebook");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 700);
		frame.setVisible(true);

		buildMainWindow(root, null);
	}

	public void buildMainWindow(String action, HashMap<String, String> args) {
		JPanel rootPanel = buildWindow(action, args);
		frame.setContentPane(new JScrollPane(rootPanel));
		frame.setTitle(rootPanel.getToolTipText());
		frame.validate();
	}

	public JPanel buildWindow(String path, HashMap<String, String> args) {
		HashMap<String, String> vars = new HashMap<String, String>();

		// we must send all session cookies in all requests
		if (cookies != null)
			for (String key : cookies.keySet())
				vars.put(key, cookies.get(key));

		// also send the current arguments (form values, etc)
		if (args != null)
			for (String key : args.keySet())
				vars.put(key, args.get(key));

		// also send arguments in the action string
		String action = path;
		int pos = path.indexOf('?');
		if (pos != -1) {
			action = path.substring(0, pos);
			HTTPUtils.addVars(path.substring(pos + 1), vars);
		}

		// lets try to get response from server...
		BuilderResult response = null;
		try {
			System.out.print("Requesting " + action);
			Object obj = null;
			synchronized (oos) {
				oos.writeObject(new ClientRequest(action, vars));
				obj = ois.readObject();
			}
			response = (BuilderResult) obj;
			System.out.print("Requested " + action + ". Got " + response.getPage());
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(frame, "Error communicating with Server: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		@SuppressWarnings("unchecked")
		HashMap<String, String> respCookies = (HashMap<String, String>) response.getCookies();

		if (respCookies != null)
			for (String key : respCookies.keySet())
				cookies.put(key, respCookies.get(key));

		if (response.getRedirectPath() != null)
			return buildWindow(response.getRedirectPath(), null);

		JPanel page = (JPanel) response.getPage();
		handleHierarchy(page);

		return page;
	}

	public void handleHierarchy(Container pane) {
		for (Component c : pane.getComponents()) {
			if (c instanceof JButton)
				((JButton) c).addActionListener(this);

			if (c instanceof JImage) {
				JImage img = (JImage) c;
				img.load();
			}

			if (c instanceof JScrollPane) {
				final JScrollPane extFrame = (JScrollPane) c;

				new Thread(new Runnable() {
					@Override
					public void run() {
						JPanel loading = new JPanel(new BorderLayout());
						loading.add(new JLabel("Loading " + extFrame.getToolTipText() + "..."));
						extFrame.setViewportView(loading);

						extFrame.setViewportView(buildWindow(extFrame.getToolTipText(), null));

						frame.invalidate();
						frame.validate();
						frame.repaint();

					}

				}).start();
			}

			if (c instanceof Container)
				handleHierarchy((Container) c);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();

		HashMap<String, String> args = new HashMap<String, String>();
		JPanel form = getForm(e.getSource());
		if (form != null) {
			action = form.getToolTipText();
			getArgs(form, args);
		}

		buildMainWindow(action, args);
	}

	JPanel getForm(Object obj) {
		if (!(obj instanceof Component))
			return null;

		Component c = (Component) obj;
		if (c.getParent() != null && c.getParent() instanceof Container) {
			Container parent = (Container) c.getParent();
			if (parent != null && parent instanceof JPanel && parent.getName() != null && parent.getName().startsWith("form"))
				return (JPanel) parent;
			else
				return getForm(parent);
		}
		return null;
	}

	void getArgs(JPanel pane, HashMap<String, String> args) {
		for (Component c : pane.getComponents()) {
			if (c instanceof JTextField) {
				JTextField txt = (JTextField) c;
				args.put(txt.getToolTipText(), txt.getText());
			} else if (c instanceof JPanel) {
				getArgs((JPanel) c, args);
			}
		}
	}

	protected void handleButton(Button button, Container pane) {
		JButton btn = new JButton(button.getName());
		btn.setActionCommand(button.getAction());
		btn.addActionListener(this);
		pane.add(btn);
	}

}
