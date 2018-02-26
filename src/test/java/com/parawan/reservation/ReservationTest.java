package com.parawan.reservation;

import com.parawan.ItemType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationTest {

    @Test
    public void constructorTest(){
        int testID = new Random().nextInt(9999);
        int testHour = new Random().nextInt(9999);
        List<ItemType> items = new ArrayList<ItemType>(Arrays.asList(ItemType.values()[new Random().nextInt(ItemType.values().length)]));
        Reservation exampleOfReservation = new Reservation(testHour, testID, items, "XXXXXX");
        assertTrue(exampleOfReservation.getHourOfReservation().equals(testHour));
        assertTrue(exampleOfReservation.getHourOfReservation().equals(testHour));
        assertTrue(exampleOfReservation.getRentedItems().equals(items));
    }


    @Test
    public void shouldEquals() {
        Reservation reservation1 = new Reservation(1, 1, new ArrayList<ItemType>(Arrays.asList(ItemType.SCREEN, ItemType.SUNBED)), "Monica");
        Reservation reservation2 = new Reservation(1, 1, new ArrayList<ItemType>(Arrays.asList()), "XX xx XX");
        Reservation reservation3 = new Reservation(1, 1, new ArrayList<ItemType>(Arrays.asList
                (ItemType.SCREEN, ItemType.SUNBED, ItemType.SCREEN, ItemType.TOWEL)), "");
        assertTrue(reservation1.equals(reservation1));
        assertTrue(reservation1.equals(reservation2));
        assertTrue(reservation2.equals(reservation3));
    }

    @Test
    public void shouldNotEquals(){
        Reservation reservation1 = new Reservation(1, 1, new ArrayList<ItemType>(Arrays.asList(ItemType.SCREEN)), "Monica");
        Reservation reservation2 = new Reservation(20, 1, new ArrayList<ItemType>(Arrays.asList(ItemType.SCREEN)), "Monica");
        Reservation reservation3 = new Reservation(20, 5, new ArrayList<ItemType>(Arrays.asList(ItemType.SCREEN)), "Monica");

        assertFalse(reservation1.equals(reservation2));
        assertFalse(reservation3.equals(reservation2));
        assertFalse(reservation3.equals(reservation1));
    }
}
