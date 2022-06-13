package com.designpattern.codingsimplified.adapterdesignpattern;

public class ChromeDriver implements WebDriver{
    @Override
    public void getElement() {
        System.out.println("Get Element from Chrome Driver");
    }

    @Override
    public void selectElement() {
        System.out.println("Select element from Chrome Driver");
    }
}
