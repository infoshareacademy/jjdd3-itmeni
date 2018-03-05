package com.parawan.com.menu;

import com.parawan.ItemType;
import com.parawan.reservation.ReservationTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ItemManagement {

    private int typedHour = 0;
    private int amountOfScreen = 200;
    private int amountOfUmbrella = 200;
    private int amountOfTowel = 200;
    private int amountOfSunbed = 200;
    private static final Logger LOG = LoggerFactory.getLogger(ItemManagement.class);
    
    public int getTypedHour() {
        return typedHour;
    }

    public void setTypedHour(int typedHour) {
        this.typedHour = typedHour;
    }

    public void itemCount(ReservationTable reservationTable, Scanner scanner) {

        while (typedHour < 8 || typedHour > 19) {
            System.out.println("Please type hour that interest You  (Beach is open from 8.00 to 19.00)");

            try {
                typedHour = Integer.parseInt(scanner.nextLine());
                LOG.debug("Canceled reservation for place with ID {}.", typedHour);
            } catch (Exception e) {
                System.out.println("Please be sure to type Integer within the bounds");
                LOG.warn("Wrong type for hour was selected.");
            }
        }

        forRentAtGivenHour(reservationTable);
    }

    public int[] forRentAtGivenHour(ReservationTable reservationTable) {

        int rentedScreenCount = 0;
        int rentedUmbrellaCount = 0;
        int rentedTowelCount = 0;
        int rentedSunbedCount = 0;

        for (int i = 0; i < reservationTable.size(); ++i) {
            if (reservationTable.get(i).getHourOfReservation() == typedHour) {
                if (reservationTable.get(i).getRentedItems().contains(ItemType.SCREEN)) {
                    rentedScreenCount++;
                    LOG.trace("Is already rented {} screens.", rentedScreenCount);
                }
                if (reservationTable.get(i).getRentedItems().contains(ItemType.UMBRELLA)) {
                    rentedUmbrellaCount++;
                    LOG.trace("Is already rented {} umbrellas.", rentedUmbrellaCount);
                }
                if (reservationTable.get(i).getRentedItems().contains(ItemType.TOWEL)) {
                    rentedTowelCount++;
                    LOG.trace("Is already rented {} towels.", rentedTowelCount);
                }
                if (reservationTable.get(i).getRentedItems().contains(ItemType.SUNBED)) {
                    rentedSunbedCount++;
                    LOG.trace("Is already rented {} sunbeds.", rentedSunbedCount);
                }
            }
        }

        int screenForRentAtGivenHour = amountOfScreen - rentedScreenCount;
        int umbrellaForRentAtGivenHour = amountOfUmbrella - rentedUmbrellaCount;
        int towelForRentAtGivenHour = amountOfTowel - rentedTowelCount;
        int sunbedForRentAtGivenHour = amountOfSunbed - rentedSunbedCount;

        int[] stillForRent = {screenForRentAtGivenHour, umbrellaForRentAtGivenHour, towelForRentAtGivenHour, sunbedForRentAtGivenHour};

        System.out.println("At " + typedHour + ":00 we have:\n ");
        System.out.println(screenForRentAtGivenHour + " screens available for rent");
        System.out.println(umbrellaForRentAtGivenHour + " umbrellas available for rent");
        System.out.println(towelForRentAtGivenHour + " towels available for rent");
        System.out.println(sunbedForRentAtGivenHour + " sunbeds available for rent");

        return stillForRent;
    }
}