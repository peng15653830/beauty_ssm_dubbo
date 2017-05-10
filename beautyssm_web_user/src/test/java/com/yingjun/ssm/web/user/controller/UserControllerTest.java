package com.yingjun.ssm.web.user.controller;

import com.yingjun.ssm.api.user.entity.User;
import com.yingjun.ssm.api.user.service.UserService;
import com.yingjun.ssm.common.dto.BootStrapTableResult;
import com.yingjun.ssm.common.util.encrypt.EncryptAndDecryptUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by xupeng on 17-4-30.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration("classpath:spring/spring-web.xml")
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

    }

    @Test
    public void TestList() throws Exception {
        List<User> users = new ArrayList<User>();
        users.add(new User());

        when(userService.getUserList(0, 50)).thenReturn(users);

        BootStrapTableResult<User> result = userController.list(0, 50);
        assertTrue(result.getData().size() > 0);
    }

    @Test
    public void TestLogin() throws Exception {
        User user = new User();
        user.setName("test");
        user.setPassword(EncryptAndDecryptUtils.md5Encrypt("123"));
        when(userService.checkLogin(user)).thenReturn(1);
//        HttpSession session = mock(HttpSession.class);
//        session.setAttribute(user.getName(),user);
//        BootStrapTableResult<User> result = userController.list(0, 50);
//        assertTrue(result.getData().size() > 0);
    }
}