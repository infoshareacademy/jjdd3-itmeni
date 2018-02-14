package com.parawan;

import com.parawan.reservation.Reservation;
import com.parawan.reservation.ReservationTable;

import java.util.List;
import java.util.stream.Collectors;

public class SnapshotOfGivenHour {

    Beach beach;
    ReservationTable reservationTable;

    public void setBeachAndReservationTable(Beach beach, ReservationTable reservationTable) {
        this.beach = beach;
        this.reservationTable = reservationTable;
    }


    public List<Reservation> getReservationsFromGivenHour(Integer hour) {
        return reservationTable.getTableOfReservations()
                .stream()
                .filter(x -> x.getHourOfReservation() == hour)
                .collect(Collectors.toList());
    }

    public Beach getSnapshot(Integer hour) {
        List<Reservation> reservationsFromGivenHour = getReservationsFromGivenHour(hour);
        beach.getPlaces().forEach(x -> match(x, reservationsFromGivenHour));
        return this.beach;
    }

    public Place match(Place place, List<Reservation> reservations) {
        Reservation reservation = reservations.stream()
                .filter(x -> x.getPlaceId() == place.getId())
                .collect(Collectors.toList())
                .get(0);
        place.setStatus(PlaceStatus.RESERVED);
        place.setRentedItems(reservation.getRentedItems());
        return place;
    }


}
