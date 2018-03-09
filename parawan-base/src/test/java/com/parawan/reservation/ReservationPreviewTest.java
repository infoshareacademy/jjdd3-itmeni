package com.parawan.reservation;

import com.parawan.Beach;
import com.parawan.ReservationPreview;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ReservationPreviewTest {

    private ReservationPreview reservationPreview;

    @Test
    void shouldThrowExceptionWhenParametersAreOutOfRange() {
        Beach beach = new Beach("testbeach", 12, 10);
        reservationPreview = new ReservationPreview();
        assertThrows(IllegalArgumentException.class, () -> {
            reservationPreview.getPlaceByCoordinates(beach, 19, 4);
        });
    }
}