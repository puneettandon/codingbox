package com.solid.tekcreek.dip;

public class DependencyInversionEx1 {

    // D - Dependency Inversion Principle - High level modules should not directly depend on low level modules  , instead they should depend on abstractions
    public static void main(String[] args) {
        MyMessenger messenger = new MyMessenger();
        messenger.send("a","solid is easy");

        MyMessenger1 myMessenger1 = new MyMessenger1("UDP");
        myMessenger1.send("a","Solid is easy");

    }
}

// Problem
// Application Layer - high level module
// here high level module directly dependent on low level modules
class MyMessenger{

    TcpProtocolHandler tcpProtocolHandler = new TcpProtocolHandler();

    public  void send(String sendTo,String message){
        tcpProtocolHandler.sendMessage("message to - "+ sendTo + " , message - "+message);
    }

}


// Transport layer - low level module
class TcpProtocolHandler{
    void sendMessage(String message){
        System.out.println("Tcp Protocol Handler sending message - "+message);
    }
}

// Solution
interface ProtocolHandler{
    void sendMessage(String message);
}

class TcpProtocolHandler1 implements ProtocolHandler{

    @Override
    public void sendMessage(String message) {
        System.out.println("Tcp Protocol Handler sending message - "+message);
    }
}

class UdpProtocolHandler implements ProtocolHandler{

    @Override
    public void sendMessage(String message) {
        System.out.println("Udp Protocol Handler sending message - "+message);
    }
}

class ProtocolHandlerFactory{
    public static ProtocolHandler getProtocolHandler(String protocol){
        if("TCP".equalsIgnoreCase(protocol)){
            return new TcpProtocolHandler1();
        }
        if("UDP".equalsIgnoreCase(protocol)){
            return new UdpProtocolHandler();
        }

        return null;
    }
}

class MyMessenger1{

    ProtocolHandler protocolHandler;

    MyMessenger1(String protocol){
        protocolHandler = ProtocolHandlerFactory.getProtocolHandler(protocol);
    }

    public  void send(String sendTo,String message){
        protocolHandler.sendMessage("message to - "+ sendTo + " , message - "+message);
    }

}
