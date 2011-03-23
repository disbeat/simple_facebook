package utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTTPUtils {
	public static final String SEPARATOR = "\r\n\r\n";

	public static HashMap<Integer, String> httpStatusCodes = new HashMap<Integer, String>() {
		private static final long serialVersionUID = -8833001836258762275L;
		{
			put(200, "OK");
			put(301, "Moved permanently");
			put(403, "Forbidden");
			put(404, "Not Found");
		}
	};

	public static HashMap<String, String> MIME_TYPES = new HashMap<String, String>() {
		private static final long serialVersionUID = -4210925884415693965L;
		{
			String image = "image/";
			put(".gif", image + "gif");
			put(".jpg", image + "jpeg");
			put(".jpeg", image + "jpeg");
			put(".png", image + "png");
			put(".ico", image + "ico");

			String text = "text/";
			put(".html", text + "html");
			put(".htm", text + "html");
			put(".txt", text + "plain");
			put(".css", text + "css");
			put(".xml", text + "xml");

			put(".js", text + "javascript");
		}
	};

	protected static Pattern pattern = Pattern.compile("(?:GET|POST) /(.*?) HTTP");

	public static String getRequestPath(String header) {
		Matcher m = pattern.matcher(header);
		if (m.find())
			return m.group(1);
		return null;
	}

	public static String getAction(String header) {
		String path = getRequestPath(header);
		if (path.indexOf('?') != -1)
			path = path.substring(0, path.indexOf('?'));
		return path;
	}

	public static HashMap<String, String> getVars(String request) {
		HashMap<String, String> vars = new HashMap<String, String>();
		if (request.startsWith("GET"))
			getRequestGETVars(request, vars);
		else if (request.startsWith("POST"))
			getRequestPOSTVars(request, vars);
		return vars;
	}

	static void getRequestGETVars(String input, HashMap<String, String> vars) {
		Matcher m = pattern.matcher(input);
		if (m.find()) {
			String path = m.group(1);

			int pos = path.indexOf('?');
			if (pos != -1) {
				addVars(path.substring(pos + 1), vars);
			}
		}
	}

	public static void addVars(String urlEncodedVars, HashMap<String, String> vars) {
		String v[] = urlEncodedVars.split("&");
		for (String var : v) {
			String keyVal[] = var.split("=");
			String key = keyVal[0];
			String val = (keyVal.length == 2) ? keyVal[1] : "";

			try {
				key = URLDecoder.decode(key, "utf-8");
				val = URLDecoder.decode(val, "utf-8");
			} catch (UnsupportedEncodingException e) {
				System.err.println("Error decoding url string: " + var + ": " + e.getMessage());
			}

			vars.put(key, val);
		}
	}

	static void getRequestPOSTVars(String input, HashMap<String, String> vars) {
		int pos = input.indexOf(SEPARATOR);
		if (pos != -1)
			addVars(input.substring(pos + SEPARATOR.length()), vars);
	}

	public static void writeHeaders(int status, long contentLength, HashMap<String, String> headers, OutputStream out) throws IOException {
		StringBuffer sb = new StringBuffer();
		String statusMsg = httpStatusCodes.get(status);
		if (statusMsg == null)
			statusMsg = "";

		headers.put("Content-Length", Long.toString(contentLength));
		sb.append("HTTP/1.1 " + status + " " + statusMsg + "\r\n");
		if (headers != null) {
			for (String key : headers.keySet()) {
				if (!key.equals("Set-Cookie"))
					sb.append(key + ": " + headers.get(key) + "\r\n");
				else {
					String cookies[] = headers.get(key).split("&");
					for (String cookie : cookies)
						sb.append(key + ": " + cookie + "\r\n");
				}
			}
		}
		sb.append("\r\n");
		out.write(sb.toString().getBytes());
	}

	public static void handleAuthCookies(HashMap<String, String> reqHeaders, HashMap<String, String> vars) {
		if (reqHeaders.containsKey("Cookie")) {
			String cookies[] = reqHeaders.get("Cookie").split(";");
			String userid = null;
			for (String cookie : cookies) {
				String parts[] = cookie.split("=");
				if ("userid".equals(parts[0].trim()))
					userid = parts[1].trim();
			}
			vars.put("userid", userid);
		}
	}

	public static void getHeaders(String input, HashMap<String, String> headers) {
		int pos = input.indexOf(SEPARATOR);
		if (pos != -1) {
			String head = input.substring(0, pos);
			String keyVal[] = head.split("\r\n");
			for (String a : keyVal) {
				int sepPos = a.indexOf(':');
				if (sepPos == -1)
					continue;
				else
					headers.put(a.substring(0, sepPos), a.substring(sepPos + 1).trim());
			}
		}
	}
	
	public static String getCookiesString(HashMap<String, String> cookies) {
		StringBuffer sb = new StringBuffer();
		for (String key : cookies.keySet())
			sb.append(key + "=" + cookies.get(key) + "&");
		return sb.toString();
	}
}
