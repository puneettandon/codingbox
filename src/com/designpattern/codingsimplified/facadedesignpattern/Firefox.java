package com.designpattern.codingsimplified.facadedesignpattern;

import java.sql.Driver;

public class Firefox {

    public static Driver getFirefoxDriver(){
        return null;
    }

    public  static void generateHtmlReport(String test,Driver driver){
        System.out.println("Generating Html report for firefox driver");
    }

    public static void generateJUnitReport(String test, Driver driver){
        System.out.println("Generating Junit report for firefox driver");
    }
}
