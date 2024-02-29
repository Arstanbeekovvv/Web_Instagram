package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.UserInfo;
import peaksoft.repository.UserInfoRepository;
import peaksoft.service.UserInfoService;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoRepository userInfoRepository;

    @Override
    public void updateUserInfoByUserId(Long id, UserInfo userInfo) {
        userInfoRepository.updateUserInfo(id, userInfo);
    }
}
