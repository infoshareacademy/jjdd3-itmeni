package com.parawan.servlets;

import com.parawan.dao.ReservationDao;
import com.parawan.model.Reservation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

@RunWith(MockitoJUnitRunner.class)
public class ItemManagementServletTest {

    @Mock
    public HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    public ReservationDao reservationDao;

    @InjectMocks
    public ItemManagementServlet itemManagementServlet;

    @Test
    public void shouldReturn() throws IOException {

        //Given
        Mockito.when(request.getParameter("hourFromForm")).thenReturn("9");
        Long idOfReservation = (long) 1;
        Reservation reservationTest = new Reservation(idOfReservation, 10, 10, "sub", "Szymon");
        List<Reservation> listOfAllReservationTest = new ArrayList<>();
        listOfAllReservationTest.add(reservationTest);
        Mockito.when(reservationDao.findByHour(9)).thenReturn(listOfAllReservationTest);
        int expectedAmountOfScreen = 199;
        int expectedAmountOfUmbrella = 199;
        int expectedAmountOfTowel = 200;
        int expectedAmountOfSunbed = 199;

        //When
        int[] result = itemManagementServlet.numberOfItemsStillToRent(request, response);

        //Then

        assertAll(
                () -> assertEquals(expectedAmountOfScreen, result[0]),
                () -> assertEquals(expectedAmountOfUmbrella, result[1]),
                () -> assertEquals(expectedAmountOfTowel, result[2]),
                () -> assertEquals(expectedAmountOfSunbed, result[3])
        );
    }
}