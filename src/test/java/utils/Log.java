package utils;

import java.util.logging.Logger;

public class Log {

    public static Logger Log = Logger.getLogger(Log.class.getName());
    
    public static void startTestCase(String testCaseName){
        Log.info("************");
        Log.info("**********************");
        Log.info("########"+testCaseName+"###########");
        Log.info("************");
        Log.info("**********************");
    }

    public static void endTestCase(String testCaseName){
        Log.info("###################");
        Log.info("#######################");
        Log.info("########"+testCaseName+"###########");
        Log.info(("##################"));
        Log.info("###############################");
    }

    public static void info(String message){
        Log.info(message);
    }

    public static void warning(String warning){
        Log.info(warning);
    }



}
