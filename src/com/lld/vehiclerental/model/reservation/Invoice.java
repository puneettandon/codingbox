package com.lld.vehiclerental.model.reservation;

public class Invoice {

    private String invoiceId;
    private String reservationId;
    private String userId;
    private double usageCharges;
    private double addonCost;
    private double addonServicesCost;
    private double tax;
    private double total;

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getUsageCharges() {
        return usageCharges;
    }

    public void setUsageCharges(double usageCharges) {
        this.usageCharges = usageCharges;
    }

    public double getAddonCost() {
        return addonCost;
    }

    public void setAddonCost(double addonCost) {
        this.addonCost = addonCost;
    }

    public double getAddonServicesCost() {
        return addonServicesCost;
    }

    public void setAddonServicesCost(double addonServicesCost) {
        this.addonServicesCost = addonServicesCost;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
