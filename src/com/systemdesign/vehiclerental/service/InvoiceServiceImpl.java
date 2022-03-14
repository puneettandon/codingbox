package com.systemdesign.vehiclerental.service;

import com.systemdesign.vehiclerental.model.reservation.Invoice;
import com.systemdesign.vehiclerental.model.reservation.VehicleReservation;

public class InvoiceServiceImpl implements InvoiceService {

    InvoiceServiceFactory invoiceServiceFactory = new InvoiceServiceFactory();

    @Override
    public Invoice computeInvoice(VehicleReservation vehicleReservation) {
        return null;
    }
}
