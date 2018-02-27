package com.parawan.com.menu;

import com.parawan.Beach;
import com.parawan.reservation.ReservationTable;

import java.io.IOException;
import java.util.Scanner;

public interface MainMenuDao {

    void showMenu(Beach beach, ReservationTable reservationTable) throws IOException;
    Integer chooseHour(Scanner scanner);
}
