package com.parawan.reservation;

import java.util.List;

public class CheckStatus {

    private List<Reservation> listOfReservations;

    public CheckStatus(List<Reservation> listOfReservations) {
        this.listOfReservations = listOfReservations;
    }

    public boolean isAlreadyReserved(Reservation checkThisReservation) {
        return listOfReservations.stream()
                .anyMatch(o -> o.equals(checkThisReservation));
    }
}
