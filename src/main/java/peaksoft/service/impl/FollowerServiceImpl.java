package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.User;
import peaksoft.repository.FollowerRepository;
import peaksoft.service.FollowerService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowerServiceImpl implements FollowerService {
    private final FollowerRepository followerRepository;
    @Override
    public int getCountSubscribers(Long id) {
        return followerRepository.getCountSubscribers(id);
    }

    @Override
    public int getCountSubscriptions(Long id) {
        return followerRepository.getCountSubscriptions(id);
    }

    @Override
    public List<User> getAllSubscribersByUserId(Long id) {
        User user = followerRepository.findByUserId(id);
        List<User> users = new ArrayList<>();
        for (Long aLong : user.getFollower().getSubscribers()) {
            User userId = followerRepository.findByUserId(aLong);
            if(userId != null) users.add(userId);
        }
        return users;
    }

    @Override
    public List<User> getAllSubscriptionsByUserId(Long id) {
        User user = followerRepository.findByUserId(id);
        List<User> users = new ArrayList<>();
        for (Long aLong : user.getFollower().getSubscriptions()) {
            User userId = followerRepository.findByUserId(aLong);
            if(userId != null) users.add(userId);
        }
        return users;
    }

    @Override
    public Boolean testFollower(Long myId, Long idUser) {
        return followerRepository.testFollower(myId, idUser);
    }

    @Override
    public void actionFollower(Long myId, Long userId) {
        Boolean tested = testFollower(myId, userId);
        if(tested) {
            followerRepository.actionSubscription(myId,userId);
        }else {
            followerRepository.actionSubscriber(myId,userId);
        }
    }
}
