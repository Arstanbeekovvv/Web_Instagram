package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entities.User;
import peaksoft.entities.UserInfo;
import peaksoft.repository.UserInfoRepository;

@Repository
@Transactional
@RequiredArgsConstructor
public class UserInfoRepoImpl implements UserInfoRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Boolean updateUserInfo(Long id, UserInfo newUserInfo) {
        UserInfo userinfo = entityManager.createQuery("select ui from UserInfo ui where ui.user.id = :uId", UserInfo.class).setParameter("uId", id).getSingleResult();
        userinfo.setFullName(newUserInfo.getFullName());
        userinfo.setBiography(newUserInfo.getBiography());
        userinfo.setGender(newUserInfo.getGender());
        userinfo.setImage(newUserInfo.getImage());
        return null;
    }
}
