package com.lld.hotelmanagementsystem;

public class RoomCharge implements BaseRoomCharge{

    double cost;

    @Override
    public Double getCost() {
        return cost;
    }

    public void setCost(double cost){
        this.cost = cost;
    }
}
