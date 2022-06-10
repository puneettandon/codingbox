package com.designpattern.codingsimplified.flyweightdesignpattern;

import java.util.Random;

public class Engineering {

    private  static  String employeeType[] = {"Developer","Tester"};
    private static  String skills[] = {"Java","C","Python","Scala"};

    public static void main(String[] args) {
        for (int i = 0;i<10;i++){
            Employee e = EmployeeFactory.getEmployee(getRandomEmployee());
            e.assignSkill(getRandomSkill());
            e.task();
        }
    }

    private static String getRandomSkill() {
        Random r = new Random();
        int randomSkill = r.nextInt(skills.length);
        return skills[randomSkill];
    }

    private static String getRandomEmployee() {
        Random r = new Random();
        int randomEmployeeType = r.nextInt(employeeType.length);
        return employeeType[randomEmployeeType];
    }
}
