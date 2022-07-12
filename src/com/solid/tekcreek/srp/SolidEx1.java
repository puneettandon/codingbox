package com.solid.tekcreek.srp;

// S - Single Responsibility Principle - A class should have one and only one reason to change
public class SolidEx1 {

    public static void main(String[] args) {

        AccountService1 accountService1 = new AccountService1();
        accountService1.openAccount();

        AccountService2 accountService2 = new AccountService2();
        accountService2.openAccount();
    }
}

// Problem
class AccountService1{

    // class handling multiple responsibilities
    public void openAccount(){
        // 1
        System.out.println("fill account internal details ");

        // 2
        System.out.println("Store account object in database ");

        // 3
        System.out.println("Send out welcome message ");
    }
}

// Solution
class AccountService2{

    AccountRepository repository = new AccountRepository();
    NotificationService notificationService = new NotificationService();

    // now primary responsibility is to fill account internal details and
    // delegate the stuff to rest of the components
    public void openAccount(){
        // 1
        System.out.println("fill account internal details ");

        repository.create();

        notificationService.sendNotification();
    }
}

class AccountRepository{

    public void create(){
        // 2
        System.out.println("Store account object in database ");
    }
}

class NotificationService{

    public void sendNotification(){
        // 3
        System.out.println("Send out welcome message ");
    }
}

