package logging;

public enum LoggingLevel {

    DEBUG("debug"), WARNING("warning"), INFO("info"), ERROR("error");
    
    String levelName = null;
    LoggingLevel(String name){
        this.levelName = name;
    }
    
    public String toString() {
        return levelName;
    }
}
