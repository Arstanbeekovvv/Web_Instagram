package peaksoft.repository;

import peaksoft.entities.User;

import java.util.List;

public interface UserRepository {
    // Crud methods

    // save
    void saveUser(User user);

    // find by id
    User findById(Long id);

    // find all
    List<User> getAllUser();

    List<User> searchUser(String userName);


    // update


    // delete

}
