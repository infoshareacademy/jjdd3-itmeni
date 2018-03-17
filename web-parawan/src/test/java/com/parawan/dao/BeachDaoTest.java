package com.parawan.dao;


import com.parawan.model.Beach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import javax.persistence.EntityManager;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BeachDaoTest{

    @Mock
    EntityManager entityManagerMock;

    @InjectMocks
    public BeachDao subject;

    @Test
    public void save(){
        // given
        Beach saveBeach = new Beach ();

        // when
        subject.save (saveBeach);

        // then
        verify (entityManagerMock, times (1)).persist (saveBeach);

    }

    @Test
    public void update(){
        // given
        Beach updateBeach = new Beach ();

        // when
        subject.update (updateBeach);

        // then
        verify (entityManagerMock, times (1)).merge (updateBeach);

    }

    @Test
    public void delete() {
        // given
        Integer dummyId = 0;
        Beach dummyBeach = new Beach ();

        // when
        subject.delete(dummyId);

        // then
        verify (entityManagerMock, times (1)).find (Beach.class,dummyId);

    }


    @Test
    public void deleteWithNoBeachFound() {
        // given
        Integer dummyId = 0;
        Beach dummyBeach = new Beach ();
        when(entityManagerMock.find(any(), any())).thenReturn(dummyBeach);

        // when
        subject.delete(dummyId);

        // then
        verify (entityManagerMock, times (1)).find (Beach.class,dummyId);
        verify (entityManagerMock, times(1)).remove(dummyBeach);

    }

    @Test
    public void findById() {
        // given
        Integer id = 0;
        Beach findBeach = new Beach ();

        // when
        subject.findById (id);

        // then
        verify (entityManagerMock,times (1)).find (findBeach.getClass (),id);

    }

}


