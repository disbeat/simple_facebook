package logging;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SFBTimeLogger extends SFBLogger {
    
    private SimpleDateFormat sdf;
    
    private SFBTimeLogger() {
        sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    }
    
    public static SFBTimeLogger getInstance() {
        if (instance == null)
            instance = new SFBTimeLogger();
        return (SFBTimeLogger) instance;
    }

    
    public void info(String text) {   
        super.log(sdf.format(new Date(System.currentTimeMillis())) + " - "+ text, LoggingLevel.INFO);
    }
    
    public void warning(String text) {   
        super.log(sdf.format(new Date(System.currentTimeMillis())) + " - "+ text, LoggingLevel.WARNING);
    }
    
    public void debug(String text) {   
        super.log(sdf.format(new Date(System.currentTimeMillis())) + " - "+ text, LoggingLevel.DEBUG);
    }
    
    @Override
    public void log(String text, LoggingLevel level) {
        super.log(sdf.format(new Date(System.currentTimeMillis())) + " - "+ text, level);
    }
    
    @Override
    public void error(String text) {
        super.error(sdf.format(new Date(System.currentTimeMillis())) + " - "+ text);
    }
    
}
