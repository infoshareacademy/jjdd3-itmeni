package com.parawan;

public class App {

    public static void main (String[] arg){

       Beach<Place> beach = new Beach<Place>();
       beach.createPlaces();
       Place temp;
       for (int i =0; i < beach.size(); i++){
          temp = (Place) beach.get(i);
          temp.showInfo();
       }
    }
}
