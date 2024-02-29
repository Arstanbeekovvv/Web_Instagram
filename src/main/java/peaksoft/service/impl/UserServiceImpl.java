package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.User;
import peaksoft.entities.UserInfo;
import peaksoft.repository.UserRepository;
import peaksoft.service.UserService;

import java.util.List;

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

    @Override
    public User findByUserName(User user) {
        List<User> userList = userRepository.getAllUser();
        try {
            for (User user1 : userList) {
                if(user.getUserName().endsWith(".com")){
                    if(user1.getEmail().equals(user.getUserName())){
                        if(user1.getPassword().equals(user.getPassword())){
                            return user1;
                        }
                    }
                }else {
                    if(user.getUserName().equals(user1.getUserName())){
                        if(user1.getPassword().equals(user.getPassword())){
                            return user1;
                        }
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.getAllUser();
    }

    @Override
    public List<User> searchUser(String userName) {
        return userRepository.searchUser("%" + userName + "%");
    }


}
