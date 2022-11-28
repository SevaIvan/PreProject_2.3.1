package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    void deleteUser(long id);
    void changeUser(User user);
    List<User> getAllUsers();
    User findUserById(long id);
}
