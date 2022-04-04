package com.lld.expenesharing.main.model;

import java.time.LocalDateTime;

public class Contribution {

    private String contributionId;
    private double contributionValue;
    private String transactionId;
    private LocalDateTime contributionDate;
    private String transactionDescription;

    public String getContributionId() {
        return contributionId;
    }

    public void setContributionId(String contributionId) {
        this.contributionId = contributionId;
    }

    public double getContributionValue() {
        return contributionValue;
    }

    public void setContributionValue(double contributionValue) {
        this.contributionValue = contributionValue;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getContributionDate() {
        return contributionDate;
    }

    public void setContributionDate(LocalDateTime contributionDate) {
        this.contributionDate = contributionDate;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }
}
