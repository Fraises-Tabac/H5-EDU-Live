package interfaces;


public interface studentOperation {
    //学生注册。头像为默认头像
    void register(String sPhone,String sNickName,String sPassword);

    //更换头像
    void updateIcon(String url);

    //更换手机号
    void updatePhone(String sPhone);

    //修改密码
    void updatePassword(String preCode,String newCode);

    //修改性别
    void updateGender(String sGender);

    //修改生日
    void updateBirthDay(String sBirthday);

    //修改简介
    void updateProfile(String sProfile);

    //修改邮箱
    void updateMail(String sMail);

    //修改所在地
    void updateLocation(String sLocation);

}
