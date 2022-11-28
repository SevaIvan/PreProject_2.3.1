package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getAllUsers() {
        List userList = entityManager.createQuery("from User", User.class).getResultList();
        return userList;
    }
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }
    @Override
    public void removeUser(Long id) {
        entityManager.remove(id);
    }
    @Override
    public void changeUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findUserById(long id) {
       return entityManager.find(User.class, id);
    }
}
