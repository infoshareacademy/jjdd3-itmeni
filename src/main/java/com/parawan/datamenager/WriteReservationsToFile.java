package com.parawan.datamenager;

import com.parawan.Beach;
import com.parawan.reservation.Reservation;
import com.parawan.reservation.ReservationTable;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteReservationsToFile {

    //File file = new File("database.beach");
    StringBuilder sb = new StringBuilder("");

    public void writeReservationsToFile(ReservationTable reservationTable, Beach beach) {

        PrintWriter pw = null;
        try {
            pw = new PrintWriter("database.beach");
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        pw.println(beach.getName() + ";" + beach.getMaxWidth() + ";" + beach.getMaxWidth() + ";");
        Reservation reservationToPrint = new Reservation();
        for (int i = 0; i < reservationTable.getTableOfReservations().size(); i++) {
            reservationToPrint = reservationTable.getTableOfReservations().get(i);

            sb.append(reservationToPrint.getHourOfReservation() + ";");
            sb.append(reservationToPrint.getPlaceId() + ";");
            sb.append(reservationToPrint.getNameOfPerson() + ";");
            reservationToPrint.getRentedItems().forEach(x -> sb.append(x).append(" "));
            sb.append(";");
            pw.println(sb);
            sb.setLength(0);
        }
        pw.close();

    }


}
