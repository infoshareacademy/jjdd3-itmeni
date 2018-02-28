package com.parawan;

import com.parawan.com.menu.*;
import com.parawan.datamanager.ReadReservationsFromFile;
import java.io.IOException;


public class App {

    public static void main(String[] args)  {

        ReadReservationsFromFile readReservationsFromFile = new ReadReservationsFromFile();
        MainMenu mainMenu = new MainMenu();
        try {
            mainMenu.showMenu(readReservationsFromFile.constructBeachFromFile(), readReservationsFromFile.constructReservationTableFromFile());
        } catch (IOException e) {
            System.out.println("No file found!");
        }
    }
}