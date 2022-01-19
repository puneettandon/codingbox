package com.solid.javatechie.ocp;


public class NotificationServiceOld {


    public void sendOtp(String medium){
        if(medium.equals("email")){
            // write email related logic
            // using java mail sender api
        }

        if(medium.equals("mobile")){
            // write mobile related logic
            // using twillio api
        }
    }

}
