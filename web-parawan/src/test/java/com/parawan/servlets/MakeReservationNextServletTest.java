package com.parawan.servlets;

import com.parawan.dao.BeachDao;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class MakeReservationNextServletTest {

    @Mock
    ReservationDao reservationDao;

    @Mock
    BeachDao beachDao;

    @Mock
    ActualBeach actualBeach;

    @Mock
    HttpServletRequest request;

    @Mock
    HttpSession httpSession;

    @Mock
    ReservationPrinter reservationPrinter;

    @InjectMocks
    MakeReservationNextServlet makeReservationNextServlet;

    @Test
    public void shouldContainsOneKeyIsAlreadyReserved() {

        //Given
        Map<String, Object> dataModel = new HashMap<>();

        Mockito.when(request.getSession()).thenReturn(httpSession);
        Mockito.when(request.getAttribute("isAlreadyReserved")).thenReturn("notNull");
        Mockito.when(request.getAttribute("isReserved")).thenReturn(null);

        //When
        Map<String, Object> result = makeReservationNextServlet.putAttributesToDataManager(dataModel, request);

        //Then
        assertTrue(result.containsKey("isAlreadyReserved"));
        assertEquals(1, result.size());
    }

    @Test
    public void shouldContainsAllEightElementsInDataManager (){

        //Given
        Map<String, Object> dataModel = new HashMap<>();

        Mockito.when(actualBeach.getMaxWidth()).thenReturn(10);
        Mockito.when(actualBeach.getMaxHeight()).thenReturn(5);
        Mockito.when(request.getParameter("chosenHour")).thenReturn("14");
        Mockito.when(request.getParameter("chosenId")).thenReturn("7");
        Place testPlace = new Place(31, false, "", false);
        List <Place> testPlaces = new ArrayList<>();
        testPlaces.add(testPlace);
        Mockito.when(reservationPrinter.beachToPrint(14)).thenReturn(testPlaces);

        //When
        Map<String, Object> result = makeReservationNextServlet.putParameterstoDataManager(dataModel, request);

        //Then
        assertEquals(9,result.size());
    }

    @Test
    public void shouldReserveScreenUmbrellaSunbed (){

        //Given
        Long idOfReservation = (long) 1;
        Reservation reservationTest = new Reservation(idOfReservation, 10, 10, "", "Szymon");
        Mockito.when(request.getParameter("chosenScreen")).thenReturn("s");
        Mockito.when(request.getParameter("chosenUmbrella")).thenReturn("u");
        Mockito.when(request.getParameter("chosenTowel")).thenReturn("");
        Mockito.when(request.getParameter("chosenSunbed")).thenReturn("b");
        String expected = "sub";

        //When
        Reservation result = makeReservationNextServlet.itemReservation(reservationTest, request);

        //Then
        assertEquals(expected, result.getRentedItems());
    }
}