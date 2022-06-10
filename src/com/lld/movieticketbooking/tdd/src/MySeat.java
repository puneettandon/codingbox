package com.lld.movieticketbooking.tdd.src;

public class MySeat {

    String seatId;
    String rowNo;
    String seatNo;

    public MySeat(String seatId, String rowNo, String seatNo) {
        this.seatId = seatId;
        this.rowNo = rowNo;
        this.seatNo = seatNo;
    }

    public String getSeatId() {
        return seatId;
    }

    public String getRowNo() {
        return rowNo;
    }

    public String getSeatNo() {
        return seatNo;
    }
}
