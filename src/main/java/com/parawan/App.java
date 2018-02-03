package com.parawan;

import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;



public class App {
    public static void main(String[] args) throws FileNotFoundException, JAXBException {

        JavaToXML myXML = new JavaToXML();
        myXML.javaToXML();
//odtąd ja wstawiam

        Beach sunnyBeach =new Beach(20, 10);
        sunnyBeach.createPlaces();


        Scanner scanner =new Scanner(System.in);
        boolean flag = true;


        while (flag) {

            System.out.println("Private beach management system - PARAWAN.              ver1.0");
            System.out.println("\nPlease specify Your action.\n");
            System.out.println("Would You like to: [r]eserve place, [c]ancel reservation, [s]ee current beach preview, \nc[h]eck storehouse status, [q]uit program");

            String answer = scanner.nextLine();

            if(answer.equals("r")){
                System.out.println("Please specify ID number from 1 to 200 to make reservation");
                int idNumber =scanner.nextInt();
                sunnyBeach.getPlaces().get(idNumber-1).setStatus(PlaceStatus.RESERVED);
            }
            else if(answer.equals("c")){
                System.out.println("Please specify ID number from 1 to 200 to cancel reservation");
                int idNumberCancel=scanner.nextInt();
                sunnyBeach.getPlaces().get(idNumberCancel-1).setStatus((PlaceStatus.FREE));

            }
            else if(answer.equals("s")){
                for(int i=0; i<sunnyBeach.places.size(); i++)
                System.out.println(sunnyBeach.places.get(i));
            }

            else if(answer.equals("q")){
                flag=false;
            }


        }
    }
}
