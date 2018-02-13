package com.parawan.com.menu;

import com.parawan.Beach;
import com.parawan.PlaceStatus;
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
    void shouldBeReservedAfterTheSecondReservationAtTheSameDateSamePlace() {
        //Given
        Beach beach = new Beach(10, 10);

        //When
        beach.createPlaces();

        //Then
        boolean result = reservation.reserve(beach, 1);
        assertEquals(true, result);
        result = reservation.reserve(beach, 1);
        assertEquals(false, result);
    }

    @Test
    void shouldInformThatPlaceIsUnavailableDuringReservationWhenItsOutOfOrder() {
        //Given
        Beach beach = new Beach(10, 20);

        //When
        beach.createPlaces();
        beach.getPlaces().get(0).setStatus(PlaceStatus.OUTOFORDER);

        //Then
        boolean result = reservation.outOfOrder(beach, 1);
        assertEquals(true, result);
    }
}