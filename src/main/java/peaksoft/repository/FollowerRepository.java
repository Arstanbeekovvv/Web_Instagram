package peaksoft.repository;

import peaksoft.entities.User;

import java.util.List;

public interface FollowerRepository {
    int getCountSubscribers(Long id);
    // Crud methods
    int getCountSubscriptions(Long id);

//    List<User> getAllSubscribersByUserId(Long id);
//

    // save

    // find by id
    User findByUserId(Long id);

    Boolean testFollower(Long myId, Long idUser);

    void actionSubscription(Long myId, Long userId);

    void actionSubscriber(Long myId, Long userId);
    // find all

    // update

    // delete
}
