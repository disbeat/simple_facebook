package utils;

import java.awt.Color;

import logging.SFBTimeLogger;
import clients.ClientRequest;
import clients.builder.InterfaceBuilder;
import controllers.IController;

public class Utils {
	public static void handleRequest(ClientRequest request, InterfaceBuilder builder) {
		String action = request.getAction().replace('/', '.');
		
		if (action.equals("favicon.ico")) {
			builder.setRedirect("http://www.facebook.com/favicon.ico");
			return;
		}

		String operationName = action.substring(action.lastIndexOf('.')+1);
		

		// If looking for some page in the root directory send to Root
		// controller
		if (operationName.isEmpty())
			operationName = "Login";
		
		SFBTimeLogger.getInstance().info("Handling action \"" + action + "\" with [" + operationName + "]");

		try {
			Class<?> c = Class.forName("controllers." + operationName);
			if (c != null && c.getGenericSuperclass() == IController.class) {
				IController t = (IController) c.newInstance();
			
				t.setVars(request.getVars());
				t.setBuilder(builder);
				t.operation();
				return;
			}
		} catch (NoClassDefFoundError e) {
		    e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		SFBTimeLogger.getInstance().error("Couldn't process action " + action);
	}
	
	
	public static String color2Hex(Color c) {
		if (c == null) c= Color.black;
		return Integer.toHexString(c.getRGB()).substring(2);
	}
}
