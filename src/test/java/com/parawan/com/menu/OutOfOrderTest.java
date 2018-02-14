package com.parawan.com.menu;

import com.parawan.Beach;
import com.parawan.PlaceStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutOfOrderTest {
    private OutOfOrder outOfOrder;

    @BeforeEach
    public void setUp() {
        outOfOrder = new OutOfOrder();

    }

    @Test
    void shouldSetPlaceStatusToOutOfOrder() {
        //Given
        Beach beach = new Beach(5, 5);

        //When
        beach.createPlaces();
        beach.getPlaces().get(9).setStatus((PlaceStatus.FREE));

        //Then
        assertTrue(outOfOrder.out(beach, 10) == PlaceStatus.OUTOFORDER);

    }


}