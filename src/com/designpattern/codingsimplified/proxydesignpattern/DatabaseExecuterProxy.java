package com.designpattern.codingsimplified.proxydesignpattern;

public class DatabaseExecuterProxy implements DatabaseExecuter{

    boolean ifAdmin;
    DatabaseExecuterImpl dbExecuter;


    public DatabaseExecuterProxy(String name,String password) {
        if(name == "ADMIN" && password == "Admin@123"){
            ifAdmin = true;
            dbExecuter = new DatabaseExecuterImpl();
        }
    }

    @Override
    public void executeDatabase(String query) throws Exception {
        if(ifAdmin){
            dbExecuter.executeDatabase(query);
        }else{
            if(query.equals("DELETE")){
                throw new Exception("DELETE not allowed for non-admin users");
            }else {
                dbExecuter.executeDatabase(query);
            }
        }

    }
}
