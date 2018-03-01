package com.parawan.reservation;

import com.parawan.Beach;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ReservationTable extends ArrayList<Reservation> {

    public void reservePlace(Beach beach) {
        ReservationMenu menu = new ReservationMenu();
        this.add(menu.makeReservation(beach, this));
    }
}
