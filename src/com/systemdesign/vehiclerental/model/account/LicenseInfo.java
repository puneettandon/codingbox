package com.systemdesign.vehiclerental.model.account;

import java.time.LocalDateTime;

public class LicenseInfo {

    private String licenseNumber;
    private LocalDateTime issueDate;
    private LocalDateTime expiryDate;
    private String issuedAtPlace;
    private String issuedInState;
    private String issuedInCountry;
    private LicenseType licenseType;

    // photo of license can be included

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getIssuedAtPlace() {
        return issuedAtPlace;
    }

    public void setIssuedAtPlace(String issuedAtPlace) {
        this.issuedAtPlace = issuedAtPlace;
    }

    public String getIssuedInState() {
        return issuedInState;
    }

    public void setIssuedInState(String issuedInState) {
        this.issuedInState = issuedInState;
    }

    public String getIssuedInCountry() {
        return issuedInCountry;
    }

    public void setIssuedInCountry(String issuedInCountry) {
        this.issuedInCountry = issuedInCountry;
    }

    public LicenseType getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(LicenseType licenseType) {
        this.licenseType = licenseType;
    }
}
