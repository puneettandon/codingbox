package com.designpattern.codingsimplified.proxydesignpattern;

public class DatabaseExecuterClient {

    public static void main(String[] args) throws Exception {
       // DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin","Admin@123");
    //    nonAdminExecuter.executeDatabase("DELETE");

        DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("ADMIN","Admin@123");
        adminExecuter.executeDatabase("DELETE");
    }
}
