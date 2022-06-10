package com.designpattern.techgranth.facadedesignpattern;

public class LaptopOnSwitch {

    SoftwareChecks softwareChecks;
    HardwareChecks hardwareChecks;

    public LaptopOnSwitch() {
        this.softwareChecks = new SoftwareChecks();
        this.hardwareChecks = new HardwareChecks();
    }

    void switchOnLaptop(){
        if(hardwareChecks.checkAllHardware() && softwareChecks.checkSoftwareOnBoot()){
            System.out.println("Switching on laptop");
        }else{
            System.out.println("Error while doing software & hardware checks......");
        }
    }
}
