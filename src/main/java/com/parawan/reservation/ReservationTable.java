package com.parawan.reservation;

import com.parawan.Beach;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ReservationTable {

    private List<Reservation> tableOfReservations = new ArrayList<Reservation>();

    public List<Reservation> getTableOfReservations() {
        return tableOfReservations;
    }

    public void setTableOfReservations(List<Reservation> tableOfReservations) {
        this.tableOfReservations = tableOfReservations;
    }

    public void reservePlace(Beach beach) {
        ReservationMenu menu = new ReservationMenu();
        tableOfReservations.add(menu.makeReservation(beach, tableOfReservations));
    }
}
