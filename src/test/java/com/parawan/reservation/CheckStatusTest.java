package com.parawan.reservation;

import com.parawan.Beach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CheckStatusTest {

    @Test
    void isAlreadyReserved() {
        Beach beach = new Beach("testbeach",10,10);
        int placeId = new Random().nextInt(beach.getMaxWidth()*beach.getMaxWidth());
        int hour = new Random().nextInt(24);
        ReservationTable reservationTable = new ReservationTable();
        Reservation reservation = new Reservation();
        reservation.setPlaceId(placeId);
        reservation.setHourOfReservation(hour);
        reservationTable.add(reservation);
        Reservation reservation2 = new Reservation();
        reservation2.setHourOfReservation(hour);
        reservation2.setPlaceId(placeId);
        CheckStatus checkStatus = new CheckStatus(reservationTable);
        
        assertTrue(checkStatus.isAlreadyReserved(reservation2));

    }



}