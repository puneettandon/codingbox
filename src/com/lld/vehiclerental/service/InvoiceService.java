package com.lld.vehiclerental.service;

import com.lld.vehiclerental.model.reservation.Invoice;
import com.lld.vehiclerental.model.reservation.VehicleReservation;

public interface InvoiceService {

    Invoice computeInvoice(VehicleReservation vehicleReservation);
}
