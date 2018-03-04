package com.parawan;

import com.parawan.com.menu.*;
import com.parawan.datamanager.ReadReservationsFromFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        ReadReservationsFromFile readReservationsFromFile = new ReadReservationsFromFile();
        MainMenu mainMenu = new MainMenu();
        try {
            mainMenu.showMenu(readReservationsFromFile.constructBeachFromFile(), readReservationsFromFile.constructReservationTableFromFile());
        } catch (IOException e) {
            LOGGER.error("Source file was not found !!!");
        }
    }
}