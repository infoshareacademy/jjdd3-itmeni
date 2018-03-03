package com.parawan.com.menu;

import com.parawan.Beach;
import com.parawan.Place;

import java.util.List;

public class ShowMapAfterSearch {

    private StringBuilder sb = new StringBuilder();
    private String symbol = "";
    private Integer placeIndex = 0;

    public void printMapAfterSearch(Beach beach) {
        List<Place> placesToPrint = beach.getPlaces();
        System.out.println("Beach status after search at: " + beach.getHourOfStatus() + ":00");
        for (int i = 0; i < beach.getMaxHeight(); i++) {
            for (int j = 0; j < beach.getMaxWidth(); j++) {
                if (beach.getPlaces().get(placeIndex).isMeetSearchCriteria()) {
                    symbol = ("     " + Integer.toString(beach.getPlaces().get(placeIndex).getId())).substring(Integer.toString(beach.getPlaces().get(placeIndex).getId()).length());
                } else {
                    symbol = "     ";
                }
                sb.append(symbol + "  ");
                placeIndex = placeIndex + 1;
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
