package com.systemdesign.vehiclerental.service;

import com.systemdesign.vehiclerental.model.reservation.Invoice;
import com.systemdesign.vehiclerental.model.reservation.VehicleReservation;

public interface InvoiceService {

    Invoice computeInvoice(VehicleReservation vehicleReservation);
}
