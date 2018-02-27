package com.parawan.datamanager;

import com.parawan.Beach;
import com.parawan.ItemType;
import com.parawan.reservation.ReservationTable;

import java.io.IOException;
import java.util.List;

public interface ReadReservationsFromFileDao {

    Beach constructBeachFromFile() throws IOException;
    ReservationTable constructReservationTableFromFile() throws IOException;
    List<ItemType> createListOfItems(String[] list);
}
