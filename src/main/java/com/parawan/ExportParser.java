package com.parawan;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class ExportParser {             // exports the current database to file

    public void exportParser(Beach beach) throws FileNotFoundException {

        PrintWriter pw = new PrintWriter("./rezerwacja2.txt");

        Place temp;

        for (int i = 0; i < beach.getPlaces().size(); i++) {
            temp = (Place) beach.getPlaces().get(i);
            //temp.showInfo();

            for (int z = 0; z < beach.getPlaces().size(); z++) {


                StringBuilder sb = new StringBuilder();
                Place place = (Place) beach.getPlaces().get(z);

                sb.append(place.getId() + ";");
                sb.append(place.getX() + ";");
                sb.append(place.getY() + ";");
                sb.append(place.getStatus() + ";");
                pw.println(sb);
            }
            pw.close();
        }
    }

}