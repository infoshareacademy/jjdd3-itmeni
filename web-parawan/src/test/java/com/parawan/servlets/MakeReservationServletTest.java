package com.parawan.servlets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class MakeReservationServletTest {

    @Mock
    HttpServletRequest request;

    @InjectMocks
    MakeReservationServlet makeReservationServlet;

    @Test
    public void gsg (){
        //Given
        List <String> possibleErrors = new ArrayList<>();
        possibleErrors.add("gsg");
        Map<String, Object> dataModel = new HashMap<>();
        Mockito.when(request.getSession().getAttribute("errors")).thenReturn(possibleErrors);

        //When
        makeReservationServlet.putErrorToDataModel(dataModel, request);

        //Then
        assertTrue(dataModel.isEmpty());



    }

}

    /*Map<String, Object> putErrorToDataModel(Map<String, Object> dataModel, HttpServletRequest req) {

        List<String> errors = (List<String>) req.getSession().getAttribute("errors");

        if (errors != null && !errors.isEmpty()) {
            dataModel.put("errors", errors);
            req.getSession().removeAttribute("errors");
        }
        return dataModel;
    }*/