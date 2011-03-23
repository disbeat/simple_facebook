package clients.gui;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import logging.SFBTimeLogger;

import utils.Utils;
import clients.ClientRequest;
import clients.builder.BuilderResult;
import clients.builder.SwingBuilder;

public class GUIClient extends Thread {
	protected Socket s = null;
	ObjectInputStream in;
	ObjectOutputStream out;

	public GUIClient(Socket socket) {
		this.s = socket;
		try {

			out = new ObjectOutputStream(s.getOutputStream());
			out.flush();
			in = new ObjectInputStream(s.getInputStream());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {

		try {

			while (true) {

				ClientRequest request = (ClientRequest) in.readObject();
				SFBTimeLogger.getInstance().info("Handling " + request.getAction() + " request");

				SwingBuilder builder = new SwingBuilder();
				Utils.handleRequest(request, builder);

				BuilderResult res = builder.getResult();
				out.writeObject(res);
				out.flush();

				SFBTimeLogger.getInstance().info("Sent " + res.getPage() + " document");
			}

		} catch (SocketException e) {

			// connection just closed, no problem on the server side
			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				out.close();
				s.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
