package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void create(User user);

    List<User> getAllUsers();

    void deleteUser(Long id);

    void updateUser(User user);

}
