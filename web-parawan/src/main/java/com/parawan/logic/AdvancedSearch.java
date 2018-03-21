package com.parawan.logic;

import com.parawan.model.Reservation;
import com.parawan.view.Place;
import com.parawan.view.ReservationPrinter;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class AdvancedSearch {

    @Inject
    private ReservationPrinter reservationPrinter;

    public List doSearch(Reservation reservation) {
        List<Place> placesFromGivenHour = reservationPrinter.beachToPrint(reservation.getHourOfReservation());
        String[] itemAbbreviations = reservation.getRentedItems().split("");
        for (Place p : placesFromGivenHour) {
            for (String s : itemAbbreviations) {
                if (p.getRentedItems().contains(s) && !s.equals("")) {
                    p.setMeetsSearchCriteria(true);
                }
            }
        }
        return placesFromGivenHour;
    }
}
