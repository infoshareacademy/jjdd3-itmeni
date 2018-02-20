package com.parawan.com.menu;

import com.parawan.ItemType;
import com.parawan.reservation.ReservationTable;

import java.util.Scanner;

public class ItemManagement {
    public void itemCount(ReservationTable reservationTable, Scanner scanner) {

        int typedHour = 0;
        int rentedScreenCount = 0;
        int rentedUmbrellaCount = 0;
        int rentedTowelCount = 0;
        int rentedSunbedCount = 0;
        int amountOfScreen = 200;
        int amountOfUmbrella = 200;
        int amountOfTowel = 200;
        int amountOfSunbed = 200;

        while (typedHour < 8 || typedHour > 19) {
            System.out.println("Please type hour that interest You  (Beach is open from 8.00 to 19.00)");

            try {
                typedHour = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Please be sure to type Integer within the bounds");
            }
        }

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

        System.out.println("At " + typedHour + " o'clock we have:\n ");
        System.out.println(screenForRentAtGivenHour + " screens available for rent");
        System.out.println(umbrellaForRentAtGivenHour + " umbrellas available for rent");
        System.out.println(towelForRentAtGivenHour + " towels available for rent");
        System.out.println(sunbedForRentAtGivenHour + " sunbeds available for rent");
    }
}
