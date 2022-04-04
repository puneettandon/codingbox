package com.lld.movieticketbooking.api;

import com.lld.movieticketbooking.services.BookingService;
import com.lld.movieticketbooking.services.PaymentService;

public class PaymentController {

    private final PaymentService paymentService;
    private final BookingService bookingService;


    public PaymentController(PaymentService paymentService, BookingService bookingService) {
        this.paymentService = paymentService;
        this.bookingService = bookingService;
    }

    public void paymentFailed(String bookingId, String user){
        paymentService.proceesPaymentFailed(bookingService.getBooking(bookingId),user);
    }

    public void paymentSuccess(String bookingId, String user){
        bookingService.confirmBooking(bookingService.getBooking(bookingId),user);
    }
}
