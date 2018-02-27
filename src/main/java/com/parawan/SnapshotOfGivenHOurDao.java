package com.parawan;

import com.parawan.reservation.Reservation;
import com.parawan.reservation.ReservationTable;

import java.util.List;

public interface SnapshotOfGivenHOurDao {

    void setBeachAndReservationTable(Beach beach, ReservationTable reservationTable);
    List<Reservation> getReservationsFromGivenHour(Integer hour);
    Beach getSnapshot(Integer hour);
    void setWhenMatch(Place place, List<Reservation> reservations);
}
