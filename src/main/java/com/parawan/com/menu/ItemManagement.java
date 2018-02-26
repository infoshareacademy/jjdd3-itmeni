package com.parawan.com.menu;

import com.parawan.ItemType;
import com.parawan.reservation.ReservationTable;

import java.util.*;

public class ItemManagement {

    private int typedHour = 0;
    private int amountOfScreen = 200;
    private int amountOfUmbrella = 200;
    private int amountOfTowel = 200;
    private int amountOfSunbed = 200;

    public void setTypedHour(int typedHour) {
        this.typedHour = typedHour;
    }

    public void itemCount(ReservationTable reservationTable, Scanner scanner) {

        while (typedHour < 8 || typedHour > 19) {
            System.out.println("Please type hour that interest You  (Beach is open from 8.00 to 19.00)");

            try {
                typedHour = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Please be sure to type Integer within the bounds");
            }
        }

        forRentAtGivenHour(reservationTable);
    }

    public int [] forRentAtGivenHour(ReservationTable reservationTable) {

        int rentedScreenCount = 0;
        int rentedUmbrellaCount = 0;
        int rentedTowelCount = 0;
        int rentedSunbedCount = 0;

        for (int i = 0; i < reservationTable.size(); ++i) {
            if (reservationTable.get(i).getHourOfReservation() == typedHour) {
                if (reservationTable.get(i).getRentedItems().contains(ItemType.SCREEN)) {
                    rentedScreenCount++;
                }
                if (reservationTable.get(i).getRentedItems().contains(ItemType.UMBRELLA)) {
                    rentedUmbrellaCount++;
                }
                if (reservationTable.get(i).getRentedItems().contains(ItemType.TOWEL)) {
                    rentedTowelCount++;
                }
                if (reservationTable.get(i).getRentedItems().contains(ItemType.SUNBED)) {
                    rentedSunbedCount++;
                }
            }
        }

        int screenForRentAtGivenHour = amountOfScreen - rentedScreenCount;
        int umbrellaForRentAtGivenHour = amountOfUmbrella - rentedUmbrellaCount;
        int towelForRentAtGivenHour = amountOfTowel - rentedTowelCount;
        int sunbedForRentAtGivenHour = amountOfSunbed - rentedSunbedCount;

        int [] stillForRent = {screenForRentAtGivenHour, umbrellaForRentAtGivenHour, towelForRentAtGivenHour, sunbedForRentAtGivenHour};

        System.out.println("At " + typedHour + ":00 we have:\n ");
        System.out.println(screenForRentAtGivenHour + " screens available for rent");
        System.out.println(umbrellaForRentAtGivenHour + " umbrellas available for rent");
        System.out.println(towelForRentAtGivenHour + " towels available for rent");
        System.out.println(sunbedForRentAtGivenHour + " sunbeds available for rent");

        return stillForRent;
    }
}
