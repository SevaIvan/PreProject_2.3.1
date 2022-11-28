package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void addUser(User user);
    void removeUser(Long id);
    void changeUser(User user);
    User findUserById(long id);

}
