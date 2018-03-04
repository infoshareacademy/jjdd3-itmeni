package com.parawan.reservation;

import com.parawan.Beach;

import java.util.ArrayList;

public class ReservationTable extends ArrayList<Reservation> {

    public void reservePlace(Beach beach) {
        ReservationMenu menu = new ReservationMenu();
        this.add(menu.makeReservation(beach, this));

    }
}
