package com.parawan;

import com.parawan.com.menu.*;
import com.parawan.datamanager.ReadReservationsFromFile;

import java.io.IOException;


public class App {

    public static void main(String[] args) throws IOException {

        ReadReservationsFromFile readReservationsFromFile = new ReadReservationsFromFile();
        MainMenu mainMenu = new MainMenu();
        mainMenu.showMenu(readReservationsFromFile.constructBeachFromFile(), readReservationsFromFile.constructReservationTableFromFile());
    }
}