package com.parawan;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ReservationPreview {

    public void reservationPreview(Beach beach) {
        for (int i = 0; i < beach.maxWidth; i++) {
            if (i == 0) {
                System.out.print("   ");
            }
            System.out.print(i+1 + "  ");
        }
        System.out.println();
        for (int y = 0; y < beach.maxHeight; y++) {
            System.out.print(y + 1 + "  ");
            for (int x = 0; x < beach.maxWidth; x++) {
                if (beach.getPlaces().get(y).getStatus() == PlaceStatus.RESERVED) {
                    System.out.print("#   ");
                } else {
                    System.out.print(".   ");
                }
            }
            System.out.println();
        }
    }
}