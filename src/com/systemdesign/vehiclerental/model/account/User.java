package com.systemdesign.vehiclerental.model.account;

public class User extends  Account{

    private LicenseInfo licenseInfo;

    public LicenseInfo getLicenseInfo() {
        return licenseInfo;
    }

    public void setLicenseInfo(LicenseInfo licenseInfo) {
        this.licenseInfo = licenseInfo;
    }
}
