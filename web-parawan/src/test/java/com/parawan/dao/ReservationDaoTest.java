package com.parawan.dao;

import com.parawan.model.Reservation;
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
public class ReservationDaoTest{

    @Mock
    EntityManager entityManagerMock;

    @InjectMocks
    public ReservationDao subject;

    @Test
    @DisplayName ("Test should saving to db")
    public void save(){
        // given
        Reservation saveReservation = new Reservation ();

        // when
        subject.save (saveReservation);

        // then
        verify (entityManagerMock, times (1)).persist (saveReservation);
    }

    @Test
    @DisplayName ("Test should updating to db")
    public void update(){
        // given
        Reservation updateReservation = new Reservation ();

        // when
        subject.update (updateReservation);

        // then
        verify (entityManagerMock, times (1)).merge (updateReservation);
    }

    @Test
    @DisplayName ("Test should removing object from db")
    public void delete(){
        // given
        Long id = 0b0L;
        Reservation deleteReservation = new Reservation ();

        // when
        subject.delete (id);

        // then
        verify (entityManagerMock, times (1)).find (Reservation.class,id);

    }

    @Test
    @DisplayName("Test should find reservation in db")
    public void findById(){
        // given
        Long id = 0b0L;
        Reservation findReservation = new Reservation ();

        // when
        subject.findById (id);

        // then
        verify (entityManagerMock,times (1)).find (findReservation.getClass (),id);

    }

}