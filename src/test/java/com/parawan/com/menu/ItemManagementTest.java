package com.parawan.com.menu;

import com.parawan.ItemType;
import com.parawan.reservation.Reservation;
import com.parawan.reservation.ReservationTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ItemManagementTest {

    private ItemManagement itemManagement;
    @BeforeEach
    public void setUp() {
        itemManagement = new ItemManagement();
    }

    @Test
    void shouldReturnActualNumberOfItems() {

        //Given
        Reservation reservation1 = new Reservation(8, 1, new ArrayList<>(Arrays.asList(ItemType.SCREEN)), "Szymon");
        Reservation reservation2 = new Reservation(9, 2, new ArrayList<>(Arrays.asList(ItemType.SCREEN, ItemType.UMBRELLA)), "Ania");
        Reservation reservation3 = new Reservation(8, 2, new ArrayList<>(Arrays.asList(ItemType.SCREEN, ItemType.UMBRELLA, ItemType.SUNBED)), "Kasia");
        ReservationTable reservationTable = new ReservationTable();

        //When
        reservationTable.add(reservation1);
        reservationTable.add(reservation2);
        reservationTable.add(reservation3);
        itemManagement.setTypedHour(8);

        //Then
        assertAll(
                () -> assertEquals(itemManagement.forRentAtGivenHour(reservationTable)[0], 198),
                () -> assertEquals(itemManagement.forRentAtGivenHour(reservationTable)[1], 199),
                () -> assertEquals(itemManagement.forRentAtGivenHour(reservationTable)[2], 200),
                () -> assertEquals(itemManagement.forRentAtGivenHour(reservationTable)[3], 199)
        );
    }
}