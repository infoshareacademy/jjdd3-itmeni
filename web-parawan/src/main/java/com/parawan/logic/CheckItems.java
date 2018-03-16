package com.parawan.logic;

import com.parawan.dao.ItemDao;
import com.parawan.dao.ReservationDao;
import com.parawan.model.Item;
import com.parawan.model.Reservation;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class CheckItems {

    @Inject
    private ReservationDao reservationDao;

    @Inject
    private ItemDao itemDao;

    public boolean isItemAvailable(String items, int hour) {

        List<Item> listOfItems = itemDao.findAll();
        List<Reservation> reservations = reservationDao.findByHour(hour);
        for (Item item : listOfItems) {
            Integer numberORentedItems = Math.toIntExact(reservations.stream()
                    .filter(x -> x.getRentedItems().contains(item.getAbbreviation()))
                    .count());
            if (items.contains(item.getAbbreviation()) && (item.getQuantity() - numberORentedItems <= 0)) {
                return false;
            }
        }
        return true;
    }
}

