package com.parawan.datamenager;

import com.parawan.Beach;
import com.parawan.reservation.ReservationTable;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadReservationsFromFile {


    public Beach constructBeachFromFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("database.beach"));
        String line = br.readLine();
        String[] beachParameters = line.split(";");
        return new Beach(beachParameters[0], Integer.parseInt(beachParameters[1]), Integer.parseInt(beachParameters[2]));
    }

    public ReservationTable constructReservationTable() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("database.beach"));
        String line = br.readLine();
        String[] reservationParameters = line.split(";");
        String[] itemsList = reservationParameters[4].split(" ");
        return null;
    }
}
