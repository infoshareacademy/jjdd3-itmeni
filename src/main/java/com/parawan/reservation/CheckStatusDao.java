package com.parawan.reservation;


public interface CheckStatusDao {

    boolean isAlreadyReserved(Reservation checkThisReservation);
}
