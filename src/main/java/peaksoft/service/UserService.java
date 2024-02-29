package peaksoft.service;

import peaksoft.entities.User;
import peaksoft.entities.UserInfo;

import java.util.List;

public interface UserService {
    // Crud

    // save
    void saveUser(User user);

    // find by id
    User findById(Long id);

    User findByUserName(User user);

    List<User> findAllUsers();

    List<User> searchUser(String userName);
    // update
}

