package h5EDULive.service.impl;

import h5EDULive.dao.UserRepository;
import h5EDULive.dao.domain.User;
import h5EDULive.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Override
    public User getInfo(int id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean getIdentity(String username) {
        return userRepository.findByUsername(username).getAttr().equals("teacher");
    }

    /* 注册 */
    @Override
    public boolean isExist(String mobile) {
        return userRepository.findByMobile(mobile) != null;
    }

    @Override
    public boolean insert(User user) {
        encryptPassword(user);
        return userRepository.save(user) != null;
    }

    private void encryptPassword(User user) {
        String password = user.getPassword();
        password = new BCryptPasswordEncoder().encode(password.trim());
        user.setPassword(password);
    }

    @Override
    public boolean isRight(int id, String preCode) {
        return new BCryptPasswordEncoder().matches(preCode, userRepository.findById(id).getPassword());
    }

    @Override
    @Transactional
    public void updatePassword(int id, String newCode) {
        newCode= new BCryptPasswordEncoder().encode(newCode.trim());
        userRepository.updateUserPassword(id, newCode);
    }

    @Override
    @Transactional
    public void updateName(int id, String name) {
        userRepository.updateUserName(id, name);
    }

    @Override
    @Transactional
    public void updateMajor(int id, String major) {
        userRepository.updateUserMajor(id, major);
    }

    @Override
    @Transactional
    public void updateGender(int id, String gender) {
        userRepository.updateUserGender(id, gender);
    }

    @Override
    @Transactional
    public void updateBirth(int id, String birth) {
        userRepository.updateUserBirthday(id, birth);
    }

    @Override
    @Transactional
    public void updateProfile(int id, String profile) {
        userRepository.updateUserProfile(id, profile);
    }

    @Override
    @Transactional
    public void updateMail(int id, String mail) {
        userRepository.updateUserMail(id, mail);
    }

    @Override
    @Transactional
    public void updateLocation(int id, String location) {
        userRepository.updateUserLocation(id, location);
    }

    @Override
    public void updateDescription(int id, String description) {
        userRepository.updateUserDescription(id, description);
    }
}
