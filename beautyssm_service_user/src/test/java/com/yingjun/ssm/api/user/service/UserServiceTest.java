package com.yingjun.ssm.api.user.service;

import com.yingjun.ssm.api.user.entity.User;
import com.yingjun.ssm.api.user.service.impl.UserServiceImpl;
import com.yingjun.ssm.common.util.cache.RedisCache;
import com.yingjun.ssm.common.util.encrypt.EncryptAndDecryptUtils;
import com.yingjun.ssm.core.user.dao.UserDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created by xupeng on 2017/4/9.
 */

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserDao userDao;

    @Mock
    private RedisCache cache;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddScore() {
        when(userDao.addScore(1)).thenReturn(1);
        assertEquals(userService.addScoreByAsy(1), 1);
    }

    @Test
    public void testGetUserList() {
        int offset = 0;
        int limit = 10;
        String cacheKey = RedisCache.CAHCENAME + "|getUserList|" + offset + "|" + limit;
        User user = new User();
        List<User> users = new ArrayList<>();
        users.add(user);
        when(cache.getListCache(cacheKey, User.class)).thenReturn(Collections.emptyList());
        when(userDao.queryAll(offset, limit)).thenReturn((users));
        when(cache.putListCacheWithExpireTime(cacheKey, userDao.queryAll(offset, limit), 1L)).thenReturn(true);
        List<User> result = userService.getUserList(offset, limit);
        Assert.assertEquals(true, result.size() > 0);
    }

    @Test
    public void testQueryByPhone() {
        User user = new User();
        user.setPhone(15801177972L);
        when(userDao.queryByPhone(15801177972L)).thenReturn(user);
        assertNotNull(userService.queryByPhone(15801177972L));
    }

    @Test
    public void testCheckLogin() {
        User user = new User();
        user.setName("test");
        user.setPassword(EncryptAndDecryptUtils.md5Encrypt("123"));
        when(userDao.checkLogin(user)).thenReturn(1);
        assertEquals(userService.checkLogin(user), 1);
    }
}
