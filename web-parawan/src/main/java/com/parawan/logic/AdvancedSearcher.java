package com.parawan.logic;

import com.parawan.model.Reservation;
import com.parawan.view.Place;
import com.parawan.view.ReservationPrinter;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class AdvancedSearcher {


    public List doSearch(Reservation reservation) {
        List<Place> placesFromGivenHour = new ReservationPrinter().beachToPrint(reservation.getHourOfReservation());
        String[] itemAbbreviations = reservation.getRentedItems().split("");
        for (Place p : placesFromGivenHour) {
            for (String s : itemAbbreviations) {
                if (p.getRentedItems().contains(s)) {
                    p.setMeetsSearchCriteria(true);
                }
            }
        }
        return placesFromGivenHour;
    }
}
