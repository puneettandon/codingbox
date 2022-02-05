package com.systemdesign.logging;

import java.io.Serializable;

import static com.systemdesign.logging.LogManager.buildChainOfLogger;
import static com.systemdesign.logging.LogManager.buildLogSubject;

public class Logger implements Cloneable, Serializable {

    private volatile static Logger logger;
    private volatile static AbstractLogger chainOfLogger;
    private volatile static LogSubject logSubject;

    private Logger(){
        if(logger != null){
            throw new IllegalStateException("Object Already created");
        }
    }

    public static Logger getInstance(){
        if(logger == null){
            synchronized (Logger.class){
                if(logger == null){
                    logger = new Logger();
                    chainOfLogger = buildChainOfLogger();
                    logSubject = buildLogSubject();
                }
            }
        }
        return  logger;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException();
    }

    protected Object readResolve(){
        return logger;
    }

    void createLog(int level,String msg){
        chainOfLogger.logMessage(level,msg,logSubject);
    }

    public void info(String msg){
        createLog(1,msg);
    }

    public void error(String msg){
        createLog(2,msg);
    }

    public void debug(String msg){
        createLog(3,msg);
    }
}
