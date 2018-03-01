package com.parawan;

import com.parawan.com.menu.*;
import com.parawan.datamanager.ReadReservationsFromFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class App {

    public static void main(String[] args)  {
        final Logger LOGGER = LoggerFactory.getLogger(App.class);
        ReadReservationsFromFile readReservationsFromFile = new ReadReservationsFromFile();
        MainMenu mainMenu = new MainMenu();
        try {
            mainMenu.showMenu(readReservationsFromFile.constructBeachFromFile(), readReservationsFromFile.constructReservationTableFromFile());
        } catch (IOException e) {
            System.out.println("No file found!");
            LOGGER.error("Source file was not find !!!");
        }
    }
}