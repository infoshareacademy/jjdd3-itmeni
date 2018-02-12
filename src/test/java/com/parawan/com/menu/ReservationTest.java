package com.parawan.com.menu;

import com.parawan.Beach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    private Reservation reservation;

    @BeforeEach
    public void setUp() {
        reservation = new Reservation();
    }

    @Test
    void makeReservation() {
        Beach beach = new Beach(10, 10);
        beach.createPlaces();

        boolean result = reservation.reserve(beach, 1);
        assertEquals(true, result);

        result = reservation.reserve(beach, 1);
        assertEquals(false, result);
    }
}