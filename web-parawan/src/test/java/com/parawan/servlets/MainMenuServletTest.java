package com.parawan.servlets;

import com.parawan.model.ActualBeach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(MockitoJUnitRunner.class)
class MainMenuServletTest {

    @Mock
    ActualBeach actualBeach;

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;

    @InjectMocks
    public MainMenuServlet servlet ;

    @Test
    void shouldContainKeyActualBeach () throws ServletException, IOException {

        assertTrue(servlet.processDataMOdel(response).containsKey("actualBeach"));
        assertTrue(servlet.processDataMOdel(response).containsValue(actualBeach));


    }

}
