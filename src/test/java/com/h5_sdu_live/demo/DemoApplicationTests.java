package com.h5_sdu_live.demo;

import h5EDULive.DemoApplication;
import h5EDULive.dao.domain.User;
import h5EDULive.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

    @Resource
    UserService userService;

    @Test
    public void register()
    {
        User user = new User();
        user.setUsername("小可爱");
        user.setPassword("123456");
        user.setMobile("555555");
        user.setAttr("student");
        userService.insert(user);
    }



}
