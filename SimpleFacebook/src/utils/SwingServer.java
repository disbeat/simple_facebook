package utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import clients.gui.GUIClient;

public class SwingServer extends Thread {
	int port = 81;

	public SwingServer(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		try {
			ServerSocket listener = new ServerSocket(port);
			while (true) {
				Socket s = listener.accept();
				new GUIClient(s).start();
			}
		} catch (IOException ioe) {
			System.out.println("IOException on socket listen: " + ioe);
			ioe.printStackTrace();
		}
	}
}
