package com.parawan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationPreviewTest {

    @Test
    void shouldThrowExceptionWhenParametersAreOutOfRange() {
        Beach beach = new Beach(10, 10);
        ReservationPreview reservationPreview = new ReservationPreview();

        assertThrows(IllegalArgumentException.class, () -> {
            reservationPreview.getPlaceByCoordinates(beach, 19, 4);
        });
    }
}