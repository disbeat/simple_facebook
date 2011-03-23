package logging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import utils.Config;

public class FileLogger extends SFBLoggerImp {
    private static String fileName = "log";
    File out, err;
    
    
    

    public FileLogger(String name) {
        out = new File(Config.getString("LOGS_PATH")+name+".out");
        err = new File(Config.getString("LOGS_PATH")+name+".err");
    }
    
    public FileLogger() {
        this(fileName);
    }

    @Override
    public synchronized void writeErrorLine(String text) {
        Writer output = null;
        try {
            output = new BufferedWriter(new FileWriter(err, true));
            output.write( text + "\n" );
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void writeOutLine(String text) {
        Writer output = null;
        try {
            output = new BufferedWriter(new FileWriter(out, true));
            output.write( text + "\n" );
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
