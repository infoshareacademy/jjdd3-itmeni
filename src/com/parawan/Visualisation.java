package com.parawan;

import java.util.Random;

public class Visualisation {

    public Visualisation(){

        for (int i = 0; i < 10 ; i++) {
        if (i == 0) {
            System.out.print("   ");
        }
        System.out.print(i+1 + "  ");
        }
        System.out.println();
        for (int y = 0; y < 200; y++) {
        System.out.print(y+1 + "  ");

        for (int x = 0; x < 10; x++) {
            //
            if (new Random().nextInt(1000) % 2 == 0) {
                System.out.print("#  ");
            } else {
                System.out.print(".  ");
            }
            // (x, y) => dany? Data.getPlace(x, y)
        }
        System.out.println();
        }
    }
}
