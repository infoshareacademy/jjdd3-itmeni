package com.parawan;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaceComparatorTest {
    @Test
    void shouldReturnTrueComparePlacesByStatus() {
        Place place1 = new Place(1, 0, 0, PlaceStatus.RESERVED);
        Place place2 = new Place(2, 20, 99, PlaceStatus.RESERVED);
        assertTrue(new PlaceComparator().comparePlaces(place1, place2));
    }

    @Test
    public void shouldReturnFalseComparePlacesByStatus() {
        Place place1 = new Place(1, 0, 0, PlaceStatus.FREE);
        Place place2 = new Place(2, 20, 99, PlaceStatus.RESERVED);
        assertFalse(new PlaceComparator().comparePlaces(place1, place2));
    }

    @Test
    public void shouldReturnFalseComparePlacesByStatusIfBothAreFree() {
        Place place1 = new Place(1, 0, 0, PlaceStatus.FREE);
        Place place2 = new Place(1, 0, 0, PlaceStatus.FREE);
        assertFalse(new PlaceComparator().comparePlaces(place1, place2));
    }

    @Test
    public void shouldReturnTrueComparePlacesByItemsIfOneMatch() {
        Place place1 = new Place(1, 0, 0, PlaceStatus.FREE);
        Place place2 = new Place(1, 0, 0, PlaceStatus.FREE);
        place1.setRentedItems(new ArrayList<ItemType>(Arrays.asList(ItemType.SUNBED, ItemType.SCREEN)));
        place2.setRentedItems(new ArrayList<ItemType>(Arrays.asList(ItemType.SUNBED, ItemType.TOWEL)));
        assertTrue(new PlaceComparator().comparePlaces(place1, place2));
    }

    @Test
    public void shouldReturnFalseComparePlacesByItemsIfNoOneMatch() {
        Place place1 = new Place(1, 0, 0, PlaceStatus.FREE);
        Place place2 = new Place(1, 0, 0, PlaceStatus.FREE);
        place1.setRentedItems(new ArrayList<ItemType>(Arrays.asList(ItemType.SCREEN)));
        place2.setRentedItems(new ArrayList<ItemType>(Arrays.asList(ItemType.SUNBED, ItemType.TOWEL)));
        assertFalse(new PlaceComparator().comparePlaces(place1, place2));
    }

    @Test
    public void shouldReturnFalseComparePlacesByItemsIfEmptyLists() {
        Place place1 = new Place(1, 0, 0, PlaceStatus.FREE);
        Place place2 = new Place(1, 0, 0, PlaceStatus.FREE);
        place1.setRentedItems(new ArrayList<ItemType>(Arrays.asList()));
        place2.setRentedItems(new ArrayList<ItemType>(Arrays.asList()));
        assertFalse(new PlaceComparator().comparePlaces(place1, place2));
    }

}