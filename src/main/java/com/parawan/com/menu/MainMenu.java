package com.parawan.com.menu;

import com.parawan.Beach;
import com.parawan.JavaToXML;
import com.parawan.ReservationPreview;
import com.parawan.SearchEngine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    public void seeMenu(Beach beach, JavaToXML javaToXML){

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Scanner scanner = new Scanner(System.in);

         boolean flag=true;


        while (flag) {

            System.out.println("\nPrivate beach management system - PARAWAN. ||     date/hour: " + dateFormat.format(date));
            System.out.println("Please specify Your action.                ||               ver 1.0 ");
            System.out.println("\nWould You like to: [r]eserve place, r[e]serve place with additional requirements," +
                    " \n[c]ancel reservation, [s]ee current beach preview, c[h]eck storehouse status, [q]uit program");

            String answer = scanner.nextLine();

            if (answer.equals("r")) {

                Reservation reservation = new Reservation();
                reservation.makeReservation(beach, scanner);

            }else if(answer.equals("e")){

                SearchEngine searchEngine =new SearchEngine();
                searchEngine.search(beach);

            }else if (answer.equals("c")) {

                CancelReservation cancelReservation = new CancelReservation();
                cancelReservation.undoReservation(beach, scanner);

            } else if (answer.equals("s")) {

                ReservationPreview reservationPreview=new ReservationPreview();
                reservationPreview.preview(beach);

            } else if (answer.equals("q")) {

                //Exit exit = new Exit();
                //exit.quitMenu(flag);
                flag = false;
                //javaToXML.savePlacesToXML(sunnyBeach.places);
                System.out.println("Thank you for using PARAWAN - your private beach management system");
            }
        }
    }
}
