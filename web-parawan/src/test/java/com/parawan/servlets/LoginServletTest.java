package com.parawan.servlets;

import com.parawan.dao.BeachDao;
import com.parawan.model.ActualBeach;
import com.parawan.model.Beach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LoginServletTest {

    @Mock
    public ActualBeach actualBeach;

    @Mock
    public BeachDao beachDao;

    @InjectMocks
    public LoginServlet loginServlet;

    @Test
    public void shouldReturnNameOfBeachThatIsAlreadySet() {

        //Given
        Mockito.when(actualBeach.getName()).thenReturn("Jelitkowo");
        String expected = "Jelitkowo";

        //When
        String result = loginServlet.setActualBeachIfNotSet(actualBeach).getName();

        //Then
        assertEquals(result, expected);
    }
    @Test
    public void shouldReturnNameOfBeachThatIsNotSetButIsFirstOnLIst() {

        //Given
        Beach beach = new Beach(1, "testBeach", 15, 10);
        List<Beach> listOfTestBeaches = new ArrayList<>();
        listOfTestBeaches.add(beach);
        Mockito.when(actualBeach.getName()).thenReturn(null);
        Mockito.when(beachDao.findAll()).thenReturn(listOfTestBeaches);

        //When
        ActualBeach result = loginServlet.setActualBeachIfNotSet(actualBeach);

        //Then
        Mockito.verify(actualBeach).setId(1);
        Mockito.verify(actualBeach).setName("testBeach");
        Mockito.verify(actualBeach).setMaxWidth(15);
        Mockito.verify(actualBeach).setMaxHeight(10);
    }
}