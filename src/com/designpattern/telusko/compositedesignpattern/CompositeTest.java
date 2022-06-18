package com.designpattern.telusko.compositedesignpattern;

public class CompositeTest {

    public static void main(String[] args) {

        Component  hd = new Leaf(4000,"HDD");
        Component  mouse = new Leaf(500,"Mouse");
        Component  monitor = new Leaf(7000,"Monitor");
        Component  ram = new Leaf(2000,"RAM");
        Component cpu = new Leaf(12000,"CPU");

        Composite ph = new Composite("Peripherial");
        Composite cabinet = new Composite("Cabinet");
        Composite mb = new Composite("MB");
        Composite computer = new Composite("Computer");

        mb.addComponent(ram);
        mb.addComponent(cpu);

        ph.addComponent(mouse);
        ph.addComponent(monitor);

        cabinet.addComponent(hd);
        cabinet.addComponent(mb);

        computer.addComponent(ph);
        computer.addComponent(cabinet);


        ram.showPrice();
        System.out.println("..........");
        monitor.showPrice();
        System.out.println("..........");
        ph.showPrice();
        System.out.println("..........");
        mb.showPrice();
        System.out.println("..........");
        cabinet.showPrice();
        System.out.println("..........");
        computer.showPrice();

    }
}
