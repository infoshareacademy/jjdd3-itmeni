package com.parawan;

import com.parawan.reservation.Reservation;
import com.parawan.reservation.ReservationTable;

import java.util.List;
import java.util.stream.Collectors;

public class SnapshotOfGivenHour {

    private Beach beach;
    private ReservationTable reservationTable;

    public void setBeachAndReservationTable(Beach beach, ReservationTable reservationTable) {
        this.beach = beach;
        this.reservationTable = reservationTable;
    }

    public List<Reservation> getReservationsFromGivenHour(Integer hour) {
        return reservationTable.stream()
                .filter(x -> x.getHourOfReservation() == hour)
                .collect(Collectors.toList());
    }

    public Beach getSnapshot(Integer hour) {
        beach.createPlaces();
        List<Reservation> reservationsFromGivenHour = getReservationsFromGivenHour(hour);
        beach.getPlaces().forEach(x -> setWhenMatch(x, reservationsFromGivenHour));
        return this.beach;
    }

    public void setWhenMatch(Place place, List<Reservation> reservations) {

        for (Reservation reservation : reservations) {
            if (place.getId() == reservation.getPlaceId()) {
                place.setStatus(PlaceStatus.RESERVED);
                place.setRentedItems(reservation.getRentedItems());
            }
        }
    }
}
