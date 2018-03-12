package com.parawan.view;

import com.parawan.dao.ReservationDao;
import com.parawan.model.ActualBeach;
import com.parawan.model.Reservation;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.List;

public class ReservationPrinter {

    @Inject
    private ReservationDao reservationDao;

    @Inject
    private ActualBeach actualBeach;

    public List<Place> beachToPrint(Integer hour){
        List<Reservation> reservations = reservationDao.findByHour(hour);
        List<Place> listOfPlaces = this.createPlaces(actualBeach.getMaxWidth(), actualBeach.getMaxHeight());
        listOfPlaces.forEach(x -> setWhenMatch(x, reservations));
        return listOfPlaces;
    }

    private List<Place> createPlaces(int maxWidth, int maxHeight) {

        List<Place> listOfPlaces = new ArrayList<>();
        int x = 0;
        int y = 0;
        for (int i = 0; i < (maxWidth * maxHeight); i++) {

            Place place = new Place(i+1, false, "", false);
            listOfPlaces.add(place);
            x++;

            if (x >= maxWidth) {
                x = 0;
                y++;
            }
        }
        return listOfPlaces;
    }


    public void setWhenMatch(Place place, List<Reservation> reservations) {

        for (Reservation reservation : reservations) {
            if (place.getId() == reservation.getPlaceId()) {
                place.setOccupied(true);
            }
        }
    }


}
