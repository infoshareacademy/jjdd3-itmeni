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
import static org.junit.jupiter.api.Assertions.assertAll;


@RunWith(MockitoJUnitRunner.class)
public class HelloServletTest {

    @Mock
    public ActualBeach actualBeach;

    @Mock
    public BeachDao beachDao;

    @InjectMocks
    public HelloServlet helloServlet;

    @Test
    public void shouldReturnNameOfBeachThatIsAlreadySet() {

        //Given
        Mockito.when(actualBeach.getName()).thenReturn("Jelitkowo");
        String expected = "Jelitkowo";

        //When
        String result = helloServlet.setActualBeachIfNotSet(actualBeach).getName();

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
        ActualBeach result = helloServlet.setActualBeachIfNotSet(actualBeach);

        //Then
        assertAll(
                () -> assertEquals((Integer) 1, result.getId()),
                () -> assertEquals("testBeach", result.getName()),
                () -> assertEquals((Integer) 15, result.getMaxWidth()),
                () -> assertEquals((Integer) 10, result.getMaxHeight())
        );
    }
}

/*
    public ActualBeach setActualBeachIfNotSet(ActualBeach actualBeach) {
        if(actualBeach.getName() == null || actualBeach.getName().isEmpty()){
            List<Beach> beaches = beachDao.findAll();
            if(beaches.size() != 0) {
                Beach firstBeachFromDatabase = beaches.get(0);
                actualBeach.setId(firstBeachFromDatabase.getId());
                actualBeach.setName(firstBeachFromDatabase.getName());
                actualBeach.setMaxWidth(firstBeachFromDatabase.getMaxWidth());
                actualBeach.setMaxHeight(firstBeachFromDatabase.getMaxHeight());
            } else {
                LOG.error("Error while loading data from database");
            }
        }
        return actualBeach;
    }*/
