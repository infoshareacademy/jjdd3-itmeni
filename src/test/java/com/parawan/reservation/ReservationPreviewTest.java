package com.parawan.reservation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationPreviewTest {


    @Test
    void shouldThrowExceptionWhenPrintedParemeters() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    ;
                });

    }
}