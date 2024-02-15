package peaksoft.service;

import peaksoft.entities.User;

public interface UserService {
    // Crud

    // save
    void saveUser(User user);

    // find by id
    User findById(Long id);
}
