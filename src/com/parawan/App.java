package com.parawan;

import java.util.Random;

public class App {

    public static void main (String[] arg){

//       Beach <Place> beachBrzezno = new Beach<Place>(20, 10);
//       beachBrzezno.createPlaces();
//       Place temp;
//       for (int i =0; i < beachBrzezno.size(); i++){
//          temp = (Place) beachBrzezno.get(i);
//          temp.showInfo();
//       }

        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                System.out.print("   ");
            }
            System.out.print(i + "  ");
        }
        System.out.println();

        for (int y = 0; y < 5; y++) {
            System.out.print(y + "  ");

            for (int x = 0; x < 5; x++) {
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
