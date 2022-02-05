package com.systemdesign.logging;

public class FileLogger implements LogObserver{

    @Override
    public void log(String msg) {
        System.out.println("Write to file: "+msg);
    }
}
