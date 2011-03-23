package clients.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;

import utils.HTTPUtils;
import utils.Utils;
import clients.ClientRequest;
import clients.builder.BuilderResult;
import clients.builder.HTMLBuilder;
import clients.builder.InterfaceBuilder;

public class HTTPClient extends Thread {
	protected Socket s = null;
	BufferedInputStream in;
	BufferedOutputStream out;

	public HTTPClient(Socket socket) {
		this.s = socket;
		try {
			in = new BufferedInputStream(s.getInputStream());
			out = new BufferedOutputStream(s.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		StringBuffer sb = new StringBuffer(1000);
		byte buffer[] = new byte[1000];
		int count = 0;

		while (true) {
			try {
				count = in.read(buffer);
				if (count == -1)
					return;
			} catch (Exception e) {
				return;
			}

			String newData = new String(buffer, 0, count);
			sb.append(newData);
			if (newData.contains(HTTPUtils.SEPARATOR))
				break;
		}
		String request = sb.toString();

		// SFBLogger.info(request);

		String action = HTTPUtils.getAction(request);
		HashMap<String, String> vars = HTTPUtils.getVars(request);

		// Lets process request headers, so we can get cookies
		HashMap<String, String> reqHeaders = new HashMap<String, String>();
		HTTPUtils.getHeaders(request, reqHeaders);
		HTTPUtils.handleAuthCookies(reqHeaders, vars);

		try {

			InterfaceBuilder builder = new HTMLBuilder(new HTMLTranslator());
			Utils.handleRequest(new ClientRequest(action, vars), builder);
			BuilderResult res = builder.getResult();

			
			
			
			String body = (String) res.getPage();
			
			// Lets start writing the response
			String redirectPath = res.getRedirectPath();

			// build headers for HTTP
			HashMap<String, String> respHeaders = new HashMap<String, String>();
			respHeaders.put("Date", new Date().toString());
			respHeaders.put("Server", "SimpleFacebook Server");
			respHeaders.put("Expires", "Thu, 01 Dec 1994 16:00:00 GMT");
			respHeaders.put("Content-Type", "text/html; charset=utf-8");

			// build the document body if any
			respHeaders.put("Set-Cookie", (String) res.getCookies());
			if (redirectPath != null) {
				respHeaders.put("Location", redirectPath);
				HTTPUtils.writeHeaders(302, 0, respHeaders, out);
			} else {
				byte respArr[] = body.toString().getBytes("utf-8");
				HTTPUtils.writeHeaders(200, respArr.length, respHeaders, out);
				out.write(respArr);
			}
			out.close();
			s.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
