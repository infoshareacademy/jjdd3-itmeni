package com.parawan.view;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationPrinterTest {

    @Test
    public void shouldContains91ItemsOnList(){

        //Given
        ReservationPrinter reservationPrinter = new ReservationPrinter();
        int expected = 13*7;

        //When
        List<Place> listWithAllPlaces =  reservationPrinter.createPlaces(13, 7);
        int result = listWithAllPlaces.size();

        //Then
        assertEquals(expected, result);
    }
}