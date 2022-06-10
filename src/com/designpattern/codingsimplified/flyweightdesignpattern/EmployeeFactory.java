package com.designpattern.codingsimplified.flyweightdesignpattern;

import java.util.HashMap;

public class EmployeeFactory {

    private static HashMap<String,Employee> m = new HashMap<>();

    public static  Employee getEmployee(String type){
        Employee p = null;
        if(m.get(type)!= null){
            p = m.get(type);
        }else{
            switch (type){
                case "Developer":
                    System.out.println("Developer Created");
                    p  = new Developer();
                    break;
                case "Tester":
                    System.out.println("Tester Created");
                    p = new Tester();
                    break;
                default:
                    System.out.println("No such employee");
            }
            m.put(type,p);
        }
        return p;
    }

}
