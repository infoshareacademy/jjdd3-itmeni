package com.parawan.logic;

import com.parawan.dao.ReservationDao;
import com.parawan.model.ActualBeach;
import com.parawan.model.Reservation;
import com.parawan.view.Place;
import com.parawan.view.ReservationPrinter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AdvancedSearchTest {

    @Mock
    private ReservationPrinter reservationPrinter;

    @InjectMocks
    private AdvancedSearch advancedSearch;

    @Test
    public void doSearch() {
        //given
        Reservation reservation = new Reservation(null,9, 1, "b", "wojtek");
        List<Place> fakeListOfPlaces = new ArrayList<>();
        fakeListOfPlaces.add(new Place(1, true,"b", false));
        Mockito.when(reservationPrinter.beachToPrint(9)).thenReturn(fakeListOfPlaces);
        //when
        List<Place> listOfPlaces = advancedSearch.doSearch(reservation);
        //then
        assertEquals(true, listOfPlaces.get(0).isMeetsSearchCriteria());
    }
}
