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
public class BeachDaoTest {

    @Mock
    EntityManager entityManagerMock;

    @InjectMocks
    public BeachDao subject;

    @Test
    @DisplayName("Should test saving to db")
    public void save() {
        // given
        Beach sampleBeach = new Beach();

        // when
        subject.save(sampleBeach);

        // then
        verify(entityManagerMock, times(1)).persist(sampleBeach);

    }

//    @Test
//    void update() {
//    }
//
//    @Test
//    void delete() {
//    }
//
//    @Test
//    void findById() {
//    }
//
//    @Test
//    void findAll() {
//    }
}

