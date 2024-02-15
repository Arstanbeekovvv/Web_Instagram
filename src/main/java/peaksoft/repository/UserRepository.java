package peaksoft.repository;

import peaksoft.entities.User;

public interface UserRepository {
    // Crud methods

    // save
    void saveUser(User user);

    // find by id
    User findById(Long id);
    // find all

    // update

    // delete
}
