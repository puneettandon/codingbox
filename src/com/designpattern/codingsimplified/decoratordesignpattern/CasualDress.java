package com.designpattern.codingsimplified.decoratordesignpattern;

public class CasualDress extends DressDecorator {

    public CasualDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding casual dress features");
    }
}
