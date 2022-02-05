package com.systemdesign.logging;

public class LogApplication {

    public static void main(String[] args) {


        Logger logger = Logger.getInstance();

        logger.info("this is info");
        logger.error("this is error");
        logger.debug("this is debug");

    }
}
