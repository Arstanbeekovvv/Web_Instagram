package peaksoft.service;

import peaksoft.entities.UserInfo;

public interface UserInfoService {

    // update
    void updateUserInfoByUserId(Long id, UserInfo userInfo);

}
