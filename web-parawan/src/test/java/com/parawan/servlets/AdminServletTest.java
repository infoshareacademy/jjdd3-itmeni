package com.parawan.servlets;

import com.parawan.dao.ItemDao;
import com.parawan.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class AdminServletTest {

    @Mock
    private ItemDao itemDao;

    @Mock
    private HttpServletRequest mockedReq;

    @Mock
    private HttpServletResponse mockedResp;

    @InjectMocks
    private AdminServlet adminServletForTests;


    @Test
    public void doPostShouldCallsetItems() throws ServletException, IOException {
        //given
        Item fakeItem = new Item("smth", "x", 1, null);
        Mockito.when(itemDao.getItemByAbbreviation("s")).thenReturn(fakeItem);
        Mockito.when(itemDao.getItemByAbbreviation("u")).thenReturn(fakeItem);
        Mockito.when(itemDao.getItemByAbbreviation("t")).thenReturn(fakeItem);
        Mockito.when(itemDao.getItemByAbbreviation("b")).thenReturn(fakeItem);
        Mockito.when(mockedReq.getParameter("screen")).thenReturn("0");
        Mockito.when(mockedReq.getParameter("umbrella")).thenReturn("0");
        Mockito.when(mockedReq.getParameter("towel")).thenReturn("0");
        Mockito.when(mockedReq.getParameter("sunbed")).thenReturn("0");
        //when
        adminServletForTests.doPost(mockedReq, mockedResp);
        //then
        Mockito.verify(itemDao, Mockito.times(1)).getItemByAbbreviation("s");
        Mockito.verify(mockedResp, Mockito.times(1)).sendRedirect("/parawan/admin?updatedItems=true");

    }
}