package com.parawan.com.menu;

import com.parawan.Beach;
import com.parawan.reservation.ReservationTable;

import java.util.Scanner;

public interface CancelReservationDao {

    void setCancelId(int cancelId);
    void setCancelHour(int cancelHour);
    void undoReservation(Beach beach, Scanner scanner, ReservationTable reservationTable);
    boolean conditionForId(Beach beach);
    boolean conditionForCancellation(ReservationTable reservationTable, int i);
    ReservationTable cancel(ReservationTable reservationTable);
}
