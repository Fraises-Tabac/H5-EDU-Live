package h5EDULive.dao.domain;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name ="user")
public class User implements UserDetails {

//    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="teacher_id")
    private String teacherId;

    private String attr;

    private String major;

    private String mobile;

    @Column(name="user_name")
    private String username;

    private String password;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public User(){}

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    //当前账号是否已经过期
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    //当前账号是否被锁
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    //当前账号证书（密码）是否过期
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    //当前账号是否被禁用
    @Override
    public boolean isEnabled() {
        return false;
    }

}
