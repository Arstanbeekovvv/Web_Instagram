package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Follower;
import peaksoft.entities.User;
import peaksoft.entities.UserInfo;
import peaksoft.repository.UserRepository;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class UserRepoImpl implements UserRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
        UserInfo info = new UserInfo();
        info.setImage("https://ca.slack-edge.com/T023L1WBFLH-U0389J9MUDV-g5833473707f-512");
        entityManager.persist(info);
        info.setUser(user);
        user.setUserInfo(info);
        Follower follower = new Follower();
        follower.setUser(user);
        user.setFollower(follower);
        entityManager.persist(follower);

    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("select s from User s", User.class).getResultList();
    }

    @Override
    public List<User> searchUser(String userName) {
        return entityManager.createQuery("select u from User u where u.userName ilike :name or u.userInfo.fullName ilike :name", User.class).setParameter("name", userName).getResultList();
    }
}
