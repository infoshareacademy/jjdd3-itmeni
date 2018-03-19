package com.parawan.dao;

import com.parawan.model.ActualBeach;
import com.parawan.model.Item;
import com.parawan.model.Reservation;
import com.parawan.model.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public List<User> findAll() {
        final Query query = entityManager.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }

    public User findByMail(String mail) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.mail =:param");
        query.setParameter("param", mail);
        User user =(User) query.getResultList().get(0);
        return user;
    }

    public User getUserToLogIn(String mail, String password) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.mail =:param1 AND u.password=:param2");
        query.setParameter("param1", mail);
        query.setParameter("param2", password);
        User user =(User) query.getResultList().get(0);
        return user;
    }

}
