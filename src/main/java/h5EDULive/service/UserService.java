package h5EDULive.service;


import h5EDULive.dao.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getInfo(int id);

    boolean getIdentity(String username);

    boolean isExist(String mobile);

    boolean insert(User user);

    boolean isRight(int id, String preCode);

    void updatePassword(int id, String newCode);

    void updateName(int id, String name);

    void updateMajor(int id, String major);

    void updateGender(int id, String gender);

    void updateBirth(int id, String birth);

    void updateProfile(int id, String profile);

    void updateMail(int id, String mail);

    void updateLocation(int id, String location);

    void updateDescription(int id, String description);

}
