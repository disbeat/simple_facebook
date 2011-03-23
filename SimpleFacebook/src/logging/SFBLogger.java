package logging;


public class SFBLogger {
    
    static SFBLogger instance = null;
    private SFBLoggerImp logger = new ConsoleLogger(); // default logger
    
    public SFBLogger() {
    }
    
    public static SFBLogger getInstance() {
        if (instance == null)
            instance = new SFBLogger();
        return instance;
    }
        
    
    public void setLogger(SFBLoggerImp logger) {
        getInstance().logger = logger;
    }
    
    public void log(String text, LoggingLevel level) {
        logger.writeOutLine(level+" - " + text);
    }
    
    public void error(String text) {
        logger.writeErrorLine(text);
    }
    
    
}
