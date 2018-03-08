package com.parawan.dao;

import com.parawan.model.Reservation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ReservationDao {

    @PersistenceContext
    private EntityManager entityManager;

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
        Query query = entityManager.createQuery("SELECT r FROM Reservation r WHERE r.hourOfReservation = :param");
        query.setParameter("param", hour);
        return query.getResultList();
    }
}
