package com.parawan.reservation;

import java.util.List;

public class CheckStatus {

    List<Reservation> listOfReservations;

    public CheckStatus(List<Reservation> listOfReservations) {
        this.listOfReservations = listOfReservations;
    }

    public boolean isAlreadyReserved(Reservation checkThisReservation){
    /*    Integer hour = checkThisReservation.getHourOfReservation();
        Integer placeId = checkThisReservation.getPlaceId();*/

        return listOfReservations.stream()
                .anyMatch(o -> o.equals(checkThisReservation));
    }
}
