package com.parawan.view;


import com.parawan.dao.ReservationDao;
import com.parawan.model.ActualBeach;
import com.parawan.model.Reservation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ReservationPrinterTest {

    @Mock
    ReservationDao reservationDao;

    @Mock
    ActualBeach actualBeach;

    @InjectMocks
    ReservationPrinter reservationPrinter;

    @Test
    public void shouldContains91ItemsOnList() {

        //Given
        ReservationPrinter reservationPrinter = new ReservationPrinter();
        int expected = 13 * 7;

        //When
        List<Place> listWithAllPlaces = reservationPrinter.createPlaces(13, 7);
        int result = listWithAllPlaces.size();

        //Then
        assertEquals(expected, result);
    }

    @Test
    public void shouldSetOccupiedStatusForPlaceToTrue() {

        //Given
        Long idOfReservation = (long) 1;
        Reservation reservationTest = new Reservation(idOfReservation, 12, 113, "sub", "Carmen");
        List<Reservation> reservations = new ArrayList<>();
        reservations.add(reservationTest);
        Place place = new Place(113, false, "", false);

        //When
        reservationPrinter.setWhenMatch(place, reservations);

        //Then
        assertTrue(place.isOccupied());
    }

    @Test
    public void shouldMapReservationsToPlaces() {

        //Given
        Long idOfReservation = (long) 1;
        Reservation reservationTest = new Reservation(idOfReservation, 14, 15, "sub", "Erika");
        List<Reservation> reservations = new ArrayList<>();
        reservations.add(reservationTest);
        Mockito.when(reservationDao.findByHour(14)).thenReturn(reservations);
        Mockito.when(actualBeach.getMaxWidth()).thenReturn(20);
        Mockito.when(actualBeach.getMaxHeight()).thenReturn(10);

        //When
        List<Place> result = reservationPrinter.beachToPrint(14);

        //Then
        assertTrue(!result.isEmpty());
        assertTrue(result.get(14).isOccupied());
    }
}