package logging;

public class ConsoleLogger extends SFBLoggerImp {
    
    public ConsoleLogger() {}

    @Override
    public synchronized void writeErrorLine(String text) {
        System.err.println(text);
    }

    @Override
    public synchronized void writeOutLine(String text) {
        System.out.println(text);
    }

}
