package com.parawan;

import java.util.Scanner;

public class SearchMenu {

    private Place searchConditions = new Place();
    private String option = "";


    Beach beach;

    Scanner sc = new Scanner(System.in);

    SearchEngine searchEngine = new SearchEngine();

    public SearchMenu(Beach beach) {
        this.beach = beach;
    }

    public void search() {
        System.out.println("Do you want no neighbours?\nType Y:");
        option = sc.nextLine().toLowerCase();
        if (option.equals("y")) {
            searchConditions.setStatus(PlaceStatus.RESERVED);
        } else {
            searchConditions.setStatus(PlaceStatus.FREE);
        }
        System.out.println("Do you want no PARAWANS nearby?\n" +
                "Type Y to confirm");
        option = sc.nextLine().toLowerCase();
        if (option.equals("y")) {
            searchConditions.putItems(ItemType.SCREEN, 1);
        }
    }
}
