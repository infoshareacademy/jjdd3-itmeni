package com.parawan;

//testclassnotingit

import java.io.*;
import java.util.Scanner;

public class Apptest {

    public static void main(String[] args) throws IOException {
        Beach beachBrzezno = new Beach(20, 10);
        beachBrzezno.createPlaces();

        //ExportParser ep = new ExportParser();
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int choosedID = 0;


        while (true) {
            System.out.println("What do you want? 1. Reserve place 2. Cancel reservation 3. Find place 4. Show Map 5. Exit program");
            x = sc.nextInt();
            if (x == 1) {
                System.out.println("Choose place to reserve by ID");
                choosedID = sc.nextInt();
                beachBrzezno.getPlaces().get(choosedID -1).setStatus(PlaceStatus.RESERVED);

            } else if (x == 2) {
                System.out.println("Choose place to cancel reservation by ID");
                choosedID = sc.nextInt();
                beachBrzezno.getPlaces().get(choosedID - 1).setStatus(PlaceStatus.FREE);
            }
                else if (x==3){
                SearchEngine se = new SearchEngine();
                se.search(beachBrzezno);

            } else if (x==4) {
                    ShowMap showMap = new ShowMap();
                    showMap.printMap(beachBrzezno);
            }

            else{
                break;
            }

           // ep.exportParser(beachBrzezno);
            x = 0;
            choosedID = 0;
        }
    }
}
