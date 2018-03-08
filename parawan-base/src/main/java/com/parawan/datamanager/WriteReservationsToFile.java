package com.parawan.datamanager;

import com.parawan.Beach;
import com.parawan.reservation.Reservation;
import com.parawan.reservation.ReservationTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteReservationsToFile {

    StringBuilder sb = new StringBuilder("");
    private final Logger LOG = LoggerFactory.getLogger(WriteReservationsToFile.class);

    public void writeReservationsToFile(ReservationTable reservationTable, Beach beach) throws FileNotFoundException {

        PrintWriter pw = new PrintWriter("database.beach");

        pw.println(beach.getName() + ";" + beach.getMaxWidth() + ";" + beach.getMaxHeight() + ";");
        Reservation reservationToPrint;
        for (int i = 0; i < reservationTable.size(); i++) {
            reservationToPrint = reservationTable.get(i);

            sb.append(reservationToPrint.getHourOfReservation() + ";");
            sb.append(reservationToPrint.getPlaceId() + ";");
            reservationToPrint.getRentedItems().forEach(x -> sb.append(x).append(" "));
            sb.append(";");
            sb.append(reservationToPrint.getNameOfPerson() + ";");
            pw.println(sb);
            sb.setLength(0);
        }
        pw.close();
    }
}
