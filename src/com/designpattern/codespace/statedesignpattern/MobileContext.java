package com.designpattern.codespace.statedesignpattern;

public class MobileContext {

    private MobileAlertState currentState;

    public MobileContext() {
        this.currentState = new Ringing(); // default
    }

    public void setState(MobileAlertState state){
        currentState = state;
    }

    public void alert(){
        currentState.alert();
    }
}
