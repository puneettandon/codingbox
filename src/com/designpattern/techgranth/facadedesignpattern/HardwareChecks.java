package com.designpattern.techgranth.facadedesignpattern;

public class HardwareChecks {

    MotherBoard motherBoard;
    Ram ram;

    public HardwareChecks() {
        this.motherBoard = new MotherBoard();
        this.ram = new Ram();
    }

    boolean checkAllHardware(){
        return  motherBoard.checkMotherBoardOnBoot() && ram.checkRamOnBoot();
    }
}
