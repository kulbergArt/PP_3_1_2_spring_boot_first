package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

@Service
public interface UserService {

    void create(User user);

    List<User> getAllUsers();

    void deleteUser(Long id);

    void updateUser(User user);

}
