package com.lld.hotelmanagementsystem;

public class RoomServiceCharge implements BaseRoomCharge{

    double cost;

    RoomCharge baseRoomCharge;

    public Double getCost() {
         baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
         return baseRoomCharge.getCost();
    }
}
