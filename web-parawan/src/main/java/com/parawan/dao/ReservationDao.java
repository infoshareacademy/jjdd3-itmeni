package com.parawan.dao;

import com.parawan.model.ActualBeach;
import com.parawan.model.Reservation;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ReservationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private ActualBeach actualBeach;

    public Long save(Reservation s) {
        entityManager.persist(s);
        return s.getIdOfReservation();
    }

    public Reservation update(Reservation s) {
        return entityManager.merge(s);
    }

    public void delete(Long id) {
        final Reservation s = entityManager.find(Reservation.class, id);
        if (s != null) {
            entityManager.remove(s);
        }
    }

    public Reservation findById(Long id) {
        return entityManager.find(Reservation.class, id);
    }

    public List<Reservation> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM Reservation s");

        return query.getResultList();
    }


    public List<Reservation> findByHour(Integer hour) {
        Query query = entityManager.createQuery("SELECT r FROM Reservation r WHERE r.hourOfReservation = :param AND "
                + "r.beach=" + actualBeach.getId());
        query.setParameter("param", hour);
        return query.getResultList();
    }

    public boolean checkIfAlreadyReserved(Reservation r){
        Query query = entityManager.createQuery("SELECT r FROM Reservation r " +
                "WHERE r.hourOfReservation = :hour AND r.placeId = :placeId AND r.beach = :beach");
        query.setParameter("hour", r.getHourOfReservation());
        query.setParameter("placeId", r.getPlaceId());
        query.setParameter("beach", r.getBeach());
        List<Reservation> foundReservations = query.getResultList();
        return (!foundReservations.isEmpty());
    }
}
