package com.designpattern.techgranth.facadedesignpattern;

public class SoftwareChecks {

    OSCheckOnBoot osCheckOnBoot;
    DriverCheck driverCheck;

    public SoftwareChecks() {
        this.osCheckOnBoot = new OSCheckOnBoot();
        this.driverCheck = new DriverCheck();
    }

    boolean checkSoftwareOnBoot(){
        return osCheckOnBoot.checkOSOnBoot() && driverCheck.checkDriverOnBoot();
    }
}
