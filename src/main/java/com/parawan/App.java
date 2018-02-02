package com.parawan;

public class App {

    public static void main (String[] arg){

       Beach<Place> beachBrzezno = new Beach<Place>(20, 10);
       beachBrzezno.createPlaces();
       Place temp;
       for (int i =0; i < beachBrzezno.size(); i++){
          temp = (Place) beachBrzezno.get(i);
          temp.showInfo();
       }
    }
}
