package ru.itis.jlab.repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.jlab.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

@Component(value = "userRepositoryJpa")
public class UserRepositoryJpaImpl implements UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Optional<User> findByConfirmCode(String code) {
        TypedQuery<User> query = entityManager.createQuery("select pu from User pu where pu.code = :code", User.class);
        query.setParameter("code", code);
        List<User> results = query.getResultList();
        User returnObject = null;
        if (!results.isEmpty()) {
            returnObject = results.get(0);
        }
        return Optional.ofNullable(returnObject);    }

    @Override
    @Transactional
    public Optional<User> findByLogin(String login) {
        TypedQuery<User> query = entityManager.createQuery("select pu from User pu where pu.login = :login", User.class);
        query.setParameter("login", login);
        List<User> results = query.getResultList();
        User returnObject = null;
        if (!results.isEmpty()) {
            returnObject = results.get(0);
        }
        return Optional.ofNullable(returnObject);
    }

    @Override
    @Transactional
    public Optional<User> findByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery("select pu from User pu where pu.email = :email", User.class);
        query.setParameter("email", email);
        List<User> results = query.getResultList();
        User returnObject = null;
        if (!results.isEmpty()) {
            returnObject = results.get(0);
        }
        return Optional.ofNullable(returnObject);
    }

    @Override
    public void deleteById(Long userId) {

    }

    @Override
    @Transactional
    public Optional<User> find(Long aLong) {
        return Optional.ofNullable(entityManager.find(User.class, aLong));
    }

    @Override
    @Transactional
    public List<User> findAll() {
        Queue<User> users = (Queue<User>) entityManager.createQuery
                ("select pu from User pu", User.class);
        return new ArrayList<>(users);

    }

    @Override
    @Transactional
    public void save(User entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void update(User entity) {

    }
}
