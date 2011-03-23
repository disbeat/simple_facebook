package utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import clients.web.HTTPClient;

public class HTTPServer extends Thread {
	int port = 80;

	public HTTPServer(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		try {
			ServerSocket listener = new ServerSocket(port);
			while (true) {
				Socket s = listener.accept();
				new HTTPClient(s).start();
			}
		} catch (IOException ioe) {
			System.out.println("IOException on socket listen: " + ioe);
			ioe.printStackTrace();
		}
	}

}
