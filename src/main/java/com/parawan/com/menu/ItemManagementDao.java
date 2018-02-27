package com.parawan.com.menu;

import com.parawan.reservation.ReservationTable;

import java.util.Scanner;

public interface ItemManagementDao {

    void setTypedHour(int typedHour);
    void itemCount(ReservationTable reservationTable, Scanner scanner);
    int [] forRentAtGivenHour(ReservationTable reservationTable);
}
