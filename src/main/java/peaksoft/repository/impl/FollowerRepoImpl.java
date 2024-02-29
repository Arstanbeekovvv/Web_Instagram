package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Follower;
import peaksoft.entities.User;
import peaksoft.repository.FollowerRepository;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class FollowerRepoImpl implements FollowerRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public int getCountSubscribers(Long id) {
        return entityManager.find(User.class, id).getFollower().getSubscribers().size();
    }

    @Override
    public int getCountSubscriptions(Long id) {
        Follower follower = entityManager.find(User.class, id).getFollower();
        return follower.getSubscriptions().size();
    }

    @Override
    public User findByUserId(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public Boolean testFollower(Long myId, Long idUser) {
        User user = entityManager.find(User.class, myId);
        boolean bln = false;
        for (Long l : user.getFollower().getSubscriptions()) {
            if (l.equals(idUser)) {
                bln = true;
            }
        }
        return bln;
    }

    @Override
    @Transactional
    public void actionSubscription(Long myId, Long userId) {
        User myUser = entityManager.find(User.class, myId);
        User user = entityManager.find(User.class, userId);

        myUser.getFollower().getSubscriptions().remove(userId);
        user.getFollower().getSubscribers().remove(myId);

        entityManager.merge(myUser);
        entityManager.merge(user);
    }

    @Override
    public void actionSubscriber(Long myId, Long userId) {
        User myUserId = entityManager.find(User.class, myId);
        User Id = entityManager.find(User.class, userId);
        myUserId.getFollower().getSubscriptions().add(userId);
        Id.getFollower().getSubscribers().add(myId);
    }

}
