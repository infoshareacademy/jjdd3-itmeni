package com.parawan.dao;

import com.parawan.model.ActualBeach;
import com.parawan.model.Item;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ItemDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private ActualBeach actualBeach;

    public void save(Item item) {
        entityManager.persist(item);
    }

    public void update(Item item) {
        entityManager.merge(item);
    }

    public List<Item> findAll() {
        final Query query = entityManager.createQuery("SELECT i FROM Item i WHERE beach.id=" + actualBeach.getId());
        return query.getResultList();
    }

    public List<String> getTypesOfItems() {
        final Query query = entityManager.createQuery("SELECT i.name FROM Item i WHERE beach.id=" + actualBeach.getId());
        return query.getResultList();
    }

    public Item getItemByAbbreviation(String s) {
        final Query query = entityManager.createQuery("SELECT i From Item i WHERE i.abbreviation =:param AND beach.id=" + actualBeach.getId());
        query.setParameter("param", s);
        Item foundItem = new Item();
        if (!query.getResultList().isEmpty()){
            foundItem = (Item) query.getResultList().get(0);
        }
        return foundItem;
    }
}
