package com.designpattern.codingsimplified.adapterdesignpattern;

public class AdapterDesignPattern {

    public static void main(String[] args) {
        ChromeDriver a = new ChromeDriver();
        a.getElement();
        a.selectElement();

        IEDriver e = new IEDriver();
        e.findElement();
        e.clickElement();

        WebDriver webIEDriver = new WebDriverAdapter(e);
        webIEDriver.getElement();
        webIEDriver.selectElement();

    }
}
