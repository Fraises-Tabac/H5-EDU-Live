package interfaces;


public interface teacherOperation {
    //教师注册。头像为默认头像
    void register(String tPhone,String tNickName,String tPassword);

    //更换头像
    void updateIcon(String url);

    //更换手机号
    void updatePhone(String tPhone);

    //修改密码
    void updatePassword(String preCode,String newCode);

    //修改性别
    void updateGender(String tGender);

    //修改生日
    void updateBirthDay(String tBirthday);

    //修改简介
    void updateProfile(String tProfile);

    //修改邮箱
    void updateMail(String tMail);

    //修改所在地
    void updateLocation(String tLocation);
    
    //修改研究领域
    void updateMajor(String major);
}
