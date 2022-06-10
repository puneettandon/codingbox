package com.designpattern.codingsimplified.facadedesignpattern;

import java.sql.Driver;

public class Chrome {

    public static Driver getChromeDriver(){
        return null;
    }

    public  static void generateHtmlReport(String test,Driver driver){
        System.out.println("Generating Html report for chrome driver");
    }

    public static void generateJUnitReport(String test, Driver driver){
        System.out.println("Generating Junit report for chrome driver");
    }
}
