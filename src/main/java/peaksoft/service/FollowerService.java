package peaksoft.service;

import peaksoft.entities.User;

import java.util.List;

public interface FollowerService {
    int getCountSubscribers(Long id);
    int getCountSubscriptions(Long id);

    List<User> getAllSubscribersByUserId(Long id);
    List<User> getAllSubscriptionsByUserId(Long id);

    Boolean testFollower(Long myId, Long idUser);

    void actionFollower(Long myId, Long userId);
}
