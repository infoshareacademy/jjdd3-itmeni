package com.parawan.com.menu;

import com.parawan.ItemType;
import com.parawan.reservation.Reservation;
import com.parawan.reservation.ReservationTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CancelReservationTest {
    private CancelReservation cancelReservation;

    @BeforeEach
    public void setUp() {
        cancelReservation = new CancelReservation();

    }

    @Test
    void shouldRemoveReservation1FromReservationList() {

        //Given
        Reservation reservation1 = new Reservation(8, 1, new ArrayList<>(Arrays.asList(ItemType.SCREEN)), "Szymon");
        Reservation reservation2 = new Reservation(8, 2, new ArrayList<>(Arrays.asList(ItemType.SCREEN, ItemType.TOWEL)), "Marek");
        ReservationTable reservationTable = new ReservationTable();

        //When
        reservationTable.add(reservation1);
        cancelReservation.setCancelHour(8);
        cancelReservation.setCancelId(1);

        //Then
        cancelReservation.cancel(reservationTable);
        assertTrue(!reservationTable.contains(reservation1));
    }

    @Test
    void shouldNotRemoveReservation2FromReservationList(){

        //Given
        Reservation reservation1 = new Reservation(8, 1, new ArrayList<>(Arrays.asList(ItemType.SCREEN)), "Szymon");
        Reservation reservation2 = new Reservation(9, 2, new ArrayList<>(Arrays.asList(ItemType.SCREEN, ItemType.TOWEL)), "Marek");
        ReservationTable reservationTable = new ReservationTable();

        //When
        reservationTable.add(reservation2);
        cancelReservation.setCancelHour(9);
        cancelReservation.setCancelId(1);

        //Then
        cancelReservation.cancel(reservationTable);
        assertTrue(reservationTable.contains(reservation2));
    }
}