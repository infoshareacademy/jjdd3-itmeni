package com.parawan.dao;

import com.parawan.model.Beach;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import javax.persistence.EntityManager;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BeachDaoTest{

    @Mock
    EntityManager entityManagerMock;

    @InjectMocks
    public BeachDao subject;

    @Test
    @DisplayName("Test should saving to db")
    public void save(){
        // given
        Beach saveBeach = new Beach ();

        // when
        subject.save (saveBeach);

        // then
        verify (entityManagerMock, times (1)).persist (saveBeach);

    }

    @Test
    @DisplayName("Test should updating object to db")
    public void update(){
        // given
        Beach updateBeach = new Beach ();

        // when
        subject.update (updateBeach);

        // then
        verify (entityManagerMock, times (1)).merge (updateBeach);
    }

    @Test
    @DisplayName("Test should removing object from db")
    public void delete() {
        // given
        Integer id = 0;
        Beach deleteBeach = new Beach ();

        // when
        subject.delete (id);

        // then
        verify (entityManagerMock, times (1)).find (Beach.class,id);

        /* DO PRZEGADANIA CZY BEZ WARTOSCI Z BAZY MOŻNA ZWERYFIKOWAC POPRAWNOSC ZACHOWANIA FUNKCJI
        verify (entityManagerMock,times (1)).remove ();
         */

    }

    @Test
    @DisplayName("Test should find object in db")
    public void findById() {
        // given
        Integer id = 0;
        Beach findBeach = new Beach ();

        // when
        subject.findById (id);

        // then
        verify (entityManagerMock,times (1)).find (findBeach.getClass (),id);
    }

//    @Test
//    @DisplayName("Test should find all objects from db")
//    public void findAll() {
//        // given
//
//        // when
//        subject.findAll ();
//
//        // then
//        verify (entityManagerMock,times (1)).createQuery ("SELECT b FROM Beach b");
//    }
}

