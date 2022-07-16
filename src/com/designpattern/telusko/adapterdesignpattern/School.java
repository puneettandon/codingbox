package com.designpattern.telusko.adapterdesignpattern;

public class School {

    public static void main(String[] args) {
        AssignmentWork aw = new AssignmentWork();
        PenAdapter penAdapter = new PenAdapter();
        aw.setPen(penAdapter);
        aw.writeAssignment("I am ready to learn to enhance my skills");
    }

}
