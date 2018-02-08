package com.parawan;

public class SeePlaces {
    public void seeEverything(Beach beach){
        for (int i = 0; i < beach.getPlaces().size(); i++)
            System.out.println(beach.getPlaces().get(i));
    }
}
