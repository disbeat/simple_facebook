import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import utils.Config;
import utils.HTTPServer;
import utils.SwingServer;

public class Main {
	public static void main(String[] args) throws IOException, SQLException, ParseException {
		Config.loadSettings();

		// logger definition - uncomment for file logger
		//SFBTimeLogger.getInstance().setLogger( new FileLogger("TesteLog") );
		
		// async calls
		new HTTPServer(Config.getInt("HTTP_PORT")).start();
		new SwingServer(Config.getInt("SWING_PORT")).start();
	}
}
