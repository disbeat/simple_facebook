package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	private static Properties settings;

	public static void loadSettings() throws IOException {
		settings = new Properties();
		FileInputStream in = new FileInputStream("config");
		settings.load(in);
		in.close();
	}

	public static String[] getStringArray(String name) {
		String str = settings.getProperty(name);
		if (str == null)
			return null;
		return str.split(",");
	}

	public static int getInt(String name) {
		return Integer.parseInt(settings.getProperty(name));
	}

	public static int getInt(String name, int defaultValue) {
		if (!settings.containsKey(name))
			return defaultValue;
		return getInt(name);
	}
	
	public static float getFloat(String name) {
		return Float.parseFloat(settings.getProperty(name));
	}

	public static float getFloat(String name, float defaultValue) {
		if (!settings.containsKey(name))
			return defaultValue;
		return getFloat(name);
	}

	public static String getString(String name) {
		return settings.getProperty(name);
	}

	public static String getString(String name, String defaultValue) {
		if (!settings.containsKey(name))
			return defaultValue;
		return getString(name);
	}
	
	public static Properties getSettings() {
		return settings;
	}
}
