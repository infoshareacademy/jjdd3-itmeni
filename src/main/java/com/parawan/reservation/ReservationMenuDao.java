package com.parawan.reservation;

import com.parawan.Beach;

public interface ReservationMenuDao {

    Reservation makeReservation(Beach beach, ReservationTable reservationTable);
    void analyzeChosenItems(String options);
}
