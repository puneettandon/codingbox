package com.lld.logging;

public class LogManager {

    protected static AbstractLogger buildChainOfLogger(){
        AbstractLogger infoLogger  = new InfoLogger(1);
        AbstractLogger errorLogger  = new ErrorLogger(2);
        AbstractLogger debugLogger  = new DebugLogger(3);

        infoLogger.setNextLoggingLevel(errorLogger);
        errorLogger.setNextLoggingLevel(debugLogger);

        return  infoLogger;
    }

    protected static LogSubject buildLogSubject(){
        LogSubject logSubject = new LogSubject();

        ConsoleLogger consoleLogger = new ConsoleLogger();
        FileLogger fileLogger = new FileLogger();

        logSubject.addObserver(1,consoleLogger);
        logSubject.addObserver(2,consoleLogger);

        logSubject.addObserver(1,fileLogger);

        return logSubject;
    }
}
