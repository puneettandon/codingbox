package com.lld.vehiclerental.service;

import com.lld.vehiclerental.model.reservation.Invoice;
import com.lld.vehiclerental.model.reservation.VehicleReservation;

public class InvoiceServiceImpl implements InvoiceService {

    InvoiceServiceFactory invoiceServiceFactory = new InvoiceServiceFactory();

    @Override
    public Invoice computeInvoice(VehicleReservation vehicleReservation) {
        return null;
    }
}
