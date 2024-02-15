package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.User;
import peaksoft.repository.UserRepository;
import peaksoft.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }
}
