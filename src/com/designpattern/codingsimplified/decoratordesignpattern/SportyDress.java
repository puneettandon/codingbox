package com.designpattern.codingsimplified.decoratordesignpattern;

public class SportyDress extends DressDecorator{


    public SportyDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding sporty dress features");
    }
}
