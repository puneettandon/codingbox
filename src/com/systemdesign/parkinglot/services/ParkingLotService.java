package com.systemdesign.parkinglot.services;

import com.systemdesign.parkinglot.exceptions.ParkingLotException;
import com.systemdesign.parkinglot.model.Car;
import com.systemdesign.parkinglot.model.ParkingLot;
import com.systemdesign.parkinglot.model.Slot;
import com.systemdesign.parkinglot.model.parking.strategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingLotService {

    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;

    public void createParkingLot(final ParkingLot parkingLot,final ParkingStrategy parkingStrategy){
        if(this.parkingLot != null){
            throw new ParkingLotException("Parking lot already exists");
        }
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;
        for(int i = 1; i<= parkingLot.getCapacity();i++){
            parkingStrategy.addSlot(i);
        }
    }

    public Integer park(final Car car){
        validateParkingLotExists();
        final Integer nextFreeSlot = parkingStrategy.getNextSlot();
        parkingLot.park(car,nextFreeSlot);
        parkingStrategy.removeSlot(nextFreeSlot);
        return nextFreeSlot;
    }

    public void makeSlotFree(final Integer slotNumber){
        validateParkingLotExists();
        parkingLot.makeSlotFree(slotNumber);
        parkingStrategy.addSlot(slotNumber);
    }

    public List<Slot> getOccupiedSlots(){
        validateParkingLotExists();
        final List<Slot> occupiedSlotsList = new ArrayList<>();
        final Map<Integer,Slot> allSlots = parkingLot.getSlots();

        for(int i =1;i<parkingLot.getCapacity();i++){
            if (allSlots.containsKey(i)) {
                final Slot slot = allSlots.get(i);
                if(!slot.isSlotFree()){
                    occupiedSlotsList.add(slot);
                }
            }
        }
        return  occupiedSlotsList;
    }

    public void validateParkingLotExists(){
        if(parkingLot == null){
            throw new ParkingLotException("Parking lot doesn't exist to park");
        }
    }

    public List<Slot> getSlotsForColor(final String color){
        final List<Slot> occupiedSlots = getOccupiedSlots();
        return occupiedSlots.stream()
                .filter(slot -> slot.getParkedCar().getColor().equals(color))
                .collect(Collectors.toList());
    }
}
