package com.parawan;

import com.parawan.reservation.Reservation;
import com.parawan.reservation.ReservationTable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class SnapshotOfGivenHourTest {
    @Test
    public void getReservationsFromGivenHourTest() {
        SnapshotOfGivenHour snapshotOfGivenHour = new SnapshotOfGivenHour();
        ReservationTable reservationTable = new ReservationTable();
        Reservation testReservation1 = new Reservation(1, 5, new ArrayList<>(Arrays.asList(ItemType.SCREEN, ItemType.SUNBED, ItemType.TOWEL)), "Bogdan");
        Reservation testReservation2 = new Reservation(1, 2, new ArrayList<>(Arrays.asList(ItemType.TOWEL)), "Ataliah");
        Reservation testReservation3 = new Reservation(1, 90, new ArrayList<>(Arrays.asList(ItemType.SCREEN)), "");
        Reservation testReservation4 = new Reservation(2, 66, new ArrayList<>(Arrays.asList(ItemType.SCREEN, ItemType.TOWEL)), "Mikael");
        Reservation testReservation5 = new Reservation(2, 19, new ArrayList<>(Arrays.asList(ItemType.TOWEL, ItemType.TOWEL)), "Isaac");
        reservationTable.add(testReservation1);
        reservationTable.add(testReservation2);
        reservationTable.add(testReservation3);
        reservationTable.add(testReservation4);
        reservationTable.add(testReservation5);
        Beach beach = new Beach("Test", 10, 10);
        snapshotOfGivenHour.setBeachAndReservationTable(beach, reservationTable);
        Beach beachAfterSearch = snapshotOfGivenHour.getSnapshot(1);
        assertTrue(beachAfterSearch.getPlaces().get(4).getStatus() == PlaceStatus.RESERVED); //because ID is index +1
    }
}
