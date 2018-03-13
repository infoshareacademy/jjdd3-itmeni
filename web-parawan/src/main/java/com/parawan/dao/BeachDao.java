package com.parawan.dao;

import com.parawan.model.Beach;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Singleton
public class BeachDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Integer save(Beach b) {
        entityManager.persist(b);
        return b.getId();
    }

    public Beach update(Beach b) {
        return entityManager.merge(b);
    }

    public void delete(Integer id) {
        final Beach b = entityManager.find(Beach.class, id);
        if (b != null) {
            entityManager.remove(b);
        }
    }

    public Beach findById(Integer id) {
        return entityManager.find(Beach.class, id);
    }

    public List findAll() {
        final Query query = entityManager.createQuery ("SELECT b FROM Beach b");

        return query.getResultList();
    }
}
