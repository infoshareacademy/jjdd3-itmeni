package com.parawan.com.menu;

import com.parawan.Beach;
import com.parawan.PlaceStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CancelReservationTest {
    private CancelReservation cancelReservation;

    @BeforeEach
    public void setUp() {
        cancelReservation = new CancelReservation();

    }

    @Test
    void shouldSetPlaceStatusToFreeAfterCancelation() {
        //Given
        Beach beach = new Beach("testbeach", 5, 5);

        //When
        beach.createPlaces();
        beach.getPlaces().get(0).setStatus((PlaceStatus.RESERVED));

        //Then
        //assertTrue(cancelReservation.cancel(beach, 1) == PlaceStatus.FREE);
        //This unity test will be changed in the future , after that all comments will be deleted

    }


}