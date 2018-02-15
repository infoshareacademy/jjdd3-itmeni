package com.parawan.reservation;

import com.parawan.Beach;
import com.parawan.ItemType;

import java.util.List;
import java.util.Scanner;

/*
This menu will be refactored and integrated by Szymon and will be probably deleted
no Set name option in menu - add!
*/
public class ReservationMenu {

    Scanner sc = new Scanner(System.in);
    Integer chosenOption = 0;
    String chosenItems;
    String chosenName;
    Reservation reservation = new Reservation();
    boolean flag=true;
    //int idNumberOutOrder = Integer.parseInt(scanner.nextLine());

    public Reservation makeReservation(Beach beach, List<Reservation> list) {
        CheckStatus checkStatus = new CheckStatus(list);
        do {
            System.out.println("Please type hour of reservation (Beach is open from 8.00 to 19.00)");

            try {
                chosenOption = Integer.parseInt(sc.nextLine());
            }
            catch (Exception e) {
                System.out.println("Please be sure to type Integer within the bounds");
            }


            reservation.setHourOfReservation(chosenOption);

            System.out.println("Please type ID of your place");
            chosenOption = Integer.parseInt(sc.nextLine());
            reservation.setPlaceId(chosenOption);

            System.out.println("Please type your name ");
            chosenName = sc.nextLine();
            reservation.setNameOfPerson(chosenName);


        } while (checkStatus.isAlreadyReserved(reservation));

        System.out.println("What items do you want to rent? [s]creen, [u]mbrella, [t]owel, sun[b]ed");
        chosenItems = sc.next();
        analyzeChosenItems(chosenItems);
        return this.reservation;
    }


    public void analyzeChosenItems(String options) {

        options = options.toLowerCase();
        if (options.contains("s")) {
            reservation.putRentedItemOnList(ItemType.SCREEN);
        }
        if (options.contains("u")) {
            reservation.putRentedItemOnList(ItemType.UMBRELLA);
        }
        if (options.contains("t")) {
            reservation.putRentedItemOnList(ItemType.TOWEL);
        }
        if (options.contains("b")) {
            reservation.putRentedItemOnList(ItemType.SUNBED);
        }

    }

}
