package com.lld.hotelmanagementsystem;

import com.lld.movieticketbooking.model.BookingStatus;

import java.util.Date;
import java.util.List;

public class RoomBooking {

    String bookingId;
    Date startDate;
    Integer durationInDays;
    BookingStatus bookingStatus;
    List<Guest> guestList;
    List<Room> roomList;
    BaseRoomCharge totalRoomCharges;
}
