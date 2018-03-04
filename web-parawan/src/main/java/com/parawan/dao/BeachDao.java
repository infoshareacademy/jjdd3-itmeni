package com.parawan.dao;

import com.parawan.model.Beach;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class BeachDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Long save(Beach b) {
        entityManager.persist(b);
        return b.getId();
    }

    public Beach update(Beach b) {
        return entityManager.merge(b);
    }

    public void delete(Long id) {
        final Beach b = entityManager.find(Beach.class, id);
        if (b != null) {
            entityManager.remove(b);
        }
    }

    public Beach findById(Long id) {
        return entityManager.find(Beach.class, id);
    }




}
