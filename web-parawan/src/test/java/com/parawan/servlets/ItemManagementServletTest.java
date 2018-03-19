package com.parawan.servlets;

import com.parawan.dao.ItemDao;
import com.parawan.dao.ReservationDao;
import com.parawan.model.Beach;
import com.parawan.model.Item;
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

    @Mock
    public ItemDao itemDao;

    @InjectMocks
    public ItemManagementServlet itemManagementServlet;

    @Test
    public void shouldReturn() throws IOException {
        Beach beach = new Beach(1, "test", 20, 20);
        //Given
        Mockito.when(request.getParameter("hourFromForm")).thenReturn("9");
        Long idOfReservation = (long) 1;
        Reservation reservationTest = new Reservation(idOfReservation, 10, 10, "sub", "Szymon");
        Item item = Mockito.mock(Item.class);
        List<Reservation> listOfAllReservationTest = new ArrayList<>();
        listOfAllReservationTest.add(reservationTest);
        Mockito.when(reservationDao.findByHour(9)).thenReturn(listOfAllReservationTest);
        Mockito.when(itemDao.getItemByAbbreviation("s")).thenReturn(item);
        Mockito.when(itemDao.getItemByAbbreviation("u")).thenReturn(item);
        Mockito.when(itemDao.getItemByAbbreviation("t")).thenReturn(item);
        Mockito.when(itemDao.getItemByAbbreviation("b")).thenReturn(item);
        Mockito.when(item.getQuantity()).thenReturn(5);
        int expectedAmountOfScreen = 4;
        int expectedAmountOfUmbrella = 4;
        int expectedAmountOfTowel = 5;
        int expectedAmountOfSunbed = 4;

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