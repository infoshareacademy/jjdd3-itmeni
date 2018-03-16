package com.parawan.servlets;

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

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class MakeReservationServletTest {

    @Mock
    HttpServletRequest request;

    @Mock
    HttpSession httpSession;

    @InjectMocks
    MakeReservationServlet makeReservationServlet;

    @Test
    public void dataModelShouldContainsSomeElements (){

        //Given
        Mockito.when(request.getSession()).thenReturn(httpSession);

        List <String> possibleErrors = new ArrayList<>();
        possibleErrors.add("potential error");
        Map<String, Object> dataModel = new HashMap<>();
        Mockito.when(httpSession.getAttribute("errors")).thenReturn(possibleErrors);

        //When
        makeReservationServlet.putErrorToDataModel(dataModel, request);

        //Then
        assertTrue(!dataModel.isEmpty());
    }



}

