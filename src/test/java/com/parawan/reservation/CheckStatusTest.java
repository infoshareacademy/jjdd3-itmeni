package com.parawan.reservation;

import com.parawan.Beach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckStatusTest {

    @Test
    void isAlreadyReserved() {
        Beach beach = new Beach(10,10);
        ReservationTable reservationTable = new ReservationTable();
        Reservation reservation = new Reservation();
        reservation.setPlaceId(10);
        reservation.setHourOfReservation(8);
        reservationTable.getTableOfReservations().add(reservation);
        CheckStatus checkStatus = new CheckStatus(reservationTable.getTableOfReservations());
        assertTrue(checkStatus.isAlreadyReserved(reservation));

    }



}