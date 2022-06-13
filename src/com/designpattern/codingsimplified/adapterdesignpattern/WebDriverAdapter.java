package com.designpattern.codingsimplified.adapterdesignpattern;

public class WebDriverAdapter implements WebDriver{

    IEDriver ieDriver;

    public WebDriverAdapter(IEDriver ieDriver){
        this.ieDriver = ieDriver;
    }

    @Override
    public void getElement() {
        ieDriver.findElement();
    }

    @Override
    public void selectElement() {
        ieDriver.clickElement();
    }
}
