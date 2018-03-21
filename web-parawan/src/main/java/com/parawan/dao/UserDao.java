package com.parawan.dao;

import com.parawan.model.User;

import javax.ejb.Stateless;
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

    public User findByMail(String email) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email =:param");
        query.setParameter("param", email);
        User user = (User) query.getResultList().get(0);
        return user;
    }

    public User getUserToLogIn(String email, String name) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email =:param1 AND u.name=:param2");
        query.setParameter("param1", email);
        query.setParameter("param2", name);
        User user = null;
        if (!query.getResultList().isEmpty()) {
            user = (User) query.getResultList().get(0);
        }
        return user;
    }
}
