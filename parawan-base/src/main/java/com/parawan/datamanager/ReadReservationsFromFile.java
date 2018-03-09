package com.parawan.datamanager;

import com.parawan.Beach;
import com.parawan.ItemType;
import com.parawan.com.menu.MainMenu;
import com.parawan.reservation.Reservation;
import com.parawan.reservation.ReservationTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadReservationsFromFile {

    private final Logger LOG = LoggerFactory.getLogger(MainMenu.class);

    public Beach constructBeachFromFile() throws IOException {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("database.beach"));
        } catch (FileNotFoundException e) {
            LOG.error("No file with data", e);
        }
        String line = br.readLine();
        String[] beachParameters = line.split(";");
        return new Beach(beachParameters[0], Integer.parseInt(beachParameters[1]), Integer.parseInt(beachParameters[2]));
    }

    public ReservationTable constructReservationTableFromFile() throws IOException {
        ReservationTable reservationTable = new ReservationTable();
        LineNumberReader lnr = null;
        try {
            lnr = new LineNumberReader(new FileReader("database.beach"));
        } catch (FileNotFoundException e) {
            LOG.error("No file with data", e);
        }
        for (String line = null; (line = lnr.readLine()) != null; ) {
            if (lnr.getLineNumber() > 1) {
                String[] reservationParameters = line.split(";");
                String[] itemsList = reservationParameters[2].split(" ");
                List<ItemType> items = createListOfItems(itemsList);
                Reservation reservation = new Reservation(Integer.parseInt(reservationParameters[0]),
                        Integer.parseInt(reservationParameters[1]), items, reservationParameters[3]);
                reservationTable.add(reservation);
            }
        }
        return reservationTable;
    }

    public List<ItemType> createListOfItems(String[] list) {
        List<ItemType> items = new ArrayList<>();
        if (!(list[0].equals(""))) {
            for (String itemName : list) {
                items.add(ItemType.valueOf(itemName));
            }
        }
        return items;
    }
}
