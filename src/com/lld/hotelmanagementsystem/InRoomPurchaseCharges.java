package com.lld.hotelmanagementsystem;

public class InRoomPurchaseCharges implements BaseRoomCharge{
    double cost;
    RoomCharge roomCharge;

    @Override
    public Double getCost() {
        roomCharge.setCost(roomCharge.getCost() + cost);
        return roomCharge.getCost();
    }
}
