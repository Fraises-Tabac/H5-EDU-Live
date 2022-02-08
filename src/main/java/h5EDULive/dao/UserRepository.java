package h5EDULive.dao;

import h5EDULive.dao.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User> {
    User findById(int id);
    User findByMobile(String phone);
    User findByUsername(String username);

    @Query(value = "update user set password=?2 where id=?1",nativeQuery = true)
    @Modifying
    void updateUserPassword(int id, String newPassword);

    @Query(value = "update user set user_name=?2 where id=?1",nativeQuery = true)
    @Modifying
    void updateUserName(int id, String newName);

    @Query(value = "update user set major=?2 where id=?1",nativeQuery = true)
    @Modifying
    void updateUserMajor(int id, String newMajor);

    @Query(value = "update user set gender=?2 where id=?1",nativeQuery = true)
    @Modifying
    void updateUserGender(int id, String newGender);

    @Query(value = "update user set birthday=?2 where id=?1",nativeQuery = true)
    @Modifying
    void updateUserBirthday(int id, String birthday);

    @Query(value = "update user set profile=?2 where id=?1",nativeQuery = true)
    @Modifying
    void updateUserProfile(int id, String profile);

    @Query(value = "update user set mail=?2 where id=?1",nativeQuery = true)
    @Modifying
    void updateUserMail(int id, String mail);

    @Query(value = "update user set location=?2 where id=?1",nativeQuery = true)
    @Modifying
    void updateUserLocation(int id, String location);

    @Query(value = "update user set description=?2 where id=?1",nativeQuery = true)
    @Modifying
    void updateUserDescription(int id, String description);
}

