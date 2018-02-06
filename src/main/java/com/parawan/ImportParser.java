package com.parawan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImportParser {            //a text file containing an existing reservation

    public void importParser() throws FileNotFoundException {

        File file = new File("./rezerwacja.txt");
        Scanner in = new Scanner(file);

        while (in.hasNextLine()) {
            String line = in.nextLine();

            String[] a = line.split(";");
//            for (int i = 0; i < a.length; i++) {
//                System.out.println("a[" + i + "] = " + a[i]);
//                System.out.println(line);
//          {
            Place p = new Place(Integer.valueOf(a[0]), Integer.valueOf(a[1]),
                    Integer.valueOf(a[2]), PlaceStatus.valueOf(a[3]));

            System.out.println(p);

        }
    }
}

