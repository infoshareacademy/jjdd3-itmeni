package com.parawan;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Visualisation {

    private String wiersz;
    private long kolumna;

    public void showVisualisation(Beach beach) {
        for (int i = 0; i < 20 ; i++) {
            if (i == 0) {
                System.out.print("   ");
            }
            System.out.print(i+1 + "  ");
        }
        System.out.println();
        for (int y = 0; y < 10; y++) {
            System.out.print(y + 1 + "  ");
            for (int x = 0; x < 18; x++) {
                if (new Random().nextInt(1000) % 2 == 0) {
                    System.out.print("#   ");
                } else {
                    System.out.print(".   ");
                }
            }
            System.out.println();
        }
//        String [] beach = new String[201];
//        for (int i =0 ; i < beach.length ; i++ ){
//            beach[i] = ""+i+1;
//            System.out.println(beach[i]);
//        }

//        for (int i = 0; i < 21; i++) {
//            if (i == 0){
//            System.out.print("   ");}
//            System.out.print(i + 1 + "  ");
//            for (int j = 0; j < 10; j++)
//                System.out.println();
//                    System.out.print("   ");
//                }
//
//            }
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Podaj miejsce rząd (format np. A-J):");
//        wiersz = scanner.nextLine();
//        System.out.println("Podaj miejsce miejsce (format np. 1-20):");
//        kolumna = scanner.nextByte();
//////// miejsce
//            for (int i = 0; i < 20; i++) {
//                if (i == 0) {
//                    System.out.print("   ");
//                }
//                System.out.print(i + 1 + "  ");
//            }
//////// RZĄD0
//            for (int j = 0; j<11; j++) {
//                switch (j){
//                    case 0:
//                        System.out.println("");
//                        break;
//                    case 1:
//                        System.out.println("A"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X");
//                        break;
//                    case 2:
//                        System.out.println("B"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X");
//                        break;
//                    case 3:
//                        System.out.println("C"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X");
//                        break;
//                    case 4:
//                        System.out.println("D"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X");
//                        break;
//                    case 5:
//                        System.out.println("E"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X");
//                        break;
//                    case 6:
//                        System.out.println("F"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X");
//                        break;
//                    case 7:
//                        System.out.println("G"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X");
//                        break;
//                    case 8:
//                        System.out.println("H"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X");
//                        break;
//                    case 9:
//                        System.out.println("I"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X");
//                        break;
//                    case 10:
//                        System.out.println("J"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"  X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X"+"   X");
//                        break;
//                    default:
//                        System.out.println("something wrong....");
//                }
//            }

    }
}
