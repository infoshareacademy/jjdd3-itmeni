package com.parawan.com.menu;

import com.parawan.Beach;
import com.parawan.Place;

import java.util.List;

public class ShowMap {

    private StringBuilder sb = new StringBuilder();
    private String symbol = "";
    private Integer placeIndex = 0;

    public void printMap(Beach beach) {
        List<Place> placesToPrint = beach.getPlaces();

        System.out.println("Status of beach at: " + beach.getHourOfStatus() + " hour");

        for (int i = 0; i < beach.getMaxHeight(); i++) {
            for (int j = 0; j < beach.getMaxWidth(); j++) {
                switch (beach.getPlaces().get(placeIndex).getStatus()) {
                    case FREE:
                        symbol = ".";
                        break;
                    case RESERVED:
                        symbol = "#";
                        break;
                    case BOOKED:
                        symbol = "X";
                        break;
                    case DIRTY:
                        symbol = "d";
                        break;
                }
                sb.append(symbol + "  ");
                placeIndex = placeIndex + 1;
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public void printMapAfterSearch(Beach beach) {
        List<Place> placesToPrint = beach.getPlaces();
        System.out.println("Status of beach after search at: " + beach.getHourOfStatus() + " hour");
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
