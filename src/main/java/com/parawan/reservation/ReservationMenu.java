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
    Reservation reservation = new Reservation();


    public Reservation makeReservation(Beach beach, List<Reservation> list) {
        CheckStatus checkStatus = new CheckStatus(list);
        do {
            System.out.println("On what hour do you want to make reservation?");
            chosenOption = sc.nextInt();
            reservation.setHourOfReservation(chosenOption);

            System.out.println("Choose ID of your place");
            chosenOption = sc.nextInt();
            reservation.setPlaceId(chosenOption);
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
