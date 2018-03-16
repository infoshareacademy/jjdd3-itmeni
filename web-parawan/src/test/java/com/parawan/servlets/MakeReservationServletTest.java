package com.parawan.servlets;

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

import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class MakeReservationServletTest {

    @Mock
    HttpServletRequest request;

    @Mock
    HttpSession httpSession;

    @Mock
    ReservationPrinter reservationPrinter;

    @InjectMocks
    MakeReservationServlet makeReservationServlet;

    @Test
    public void dataModelShouldContainsSomeElements() {

        //Given
        Mockito.when(request.getSession()).thenReturn(httpSession);

        List<String> possibleErrors = new ArrayList<>();
        possibleErrors.add("potential error");
        Map<String, Object> dataModel = new HashMap<>();
        Mockito.when(httpSession.getAttribute("errors")).thenReturn(possibleErrors);

        //When
        makeReservationServlet.putErrorToDataModel(dataModel, request);

        //Then
        assertTrue(!dataModel.isEmpty());
    }

    @Test
    public void dataModelShouldContainsKeyValuePlacesAndHour() {

        //Given
        Mockito.when(request.getParameter("status")).thenReturn("13");
        Place testPlace = new Place(21, false, "", false);
        Map<String, Object> dataModel = new HashMap<>();
        List<Place> testPlaces = new ArrayList<>();
        testPlaces.add(testPlace);
        Mockito.when(reservationPrinter.beachToPrint(13)).thenReturn(testPlaces);

        //When
        makeReservationServlet.putPlacesAndStatusToDataModel(dataModel, request);

        //Then
        assertTrue(!dataModel.isEmpty());
        assertTrue(dataModel.containsKey("places"));
        assertTrue(dataModel.containsKey("hour"));
    }
}