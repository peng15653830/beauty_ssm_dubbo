package com.yingjun.ssm.core.user.dao;

import com.yingjun.ssm.api.user.entity.User;
import com.yingjun.ssm.common.util.encrypt.EncryptAndDecryptUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author xupeng
 */
@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {

    @Mock
    private UserDao userDao;

    @Test
    public void testAddScore() {
        when(userDao.addScore(anyInt())).thenReturn(1);
        assertEquals(userDao.addScore(anyInt()), 1);
    }

    @Test
    public void testInsert() {
        User user = mock(User.class);
        when(userDao.insert(user)).thenReturn(1);
        assertEquals(1, userDao.insert(user));
    }

    @Test
    public void testUpdate() {
        when(userDao.update(any(User.class))).thenReturn(1);
        assertEquals(1, userDao.update(any(User.class)));
    }

    @Test
    public void testGet() {
        User user = new User();
        user.setId(1);
        user.setName("test");
        when(userDao.get(1)).thenReturn(user);
        assertEquals(userDao.get(1).getName(), "test");
    }

    @Test
    public void testCheckLogin() {
        User user = new User();
        user.setName("test");
        user.setPassword(EncryptAndDecryptUtils.md5Encrypt("123"));
        when(userDao.checkLogin(user)).thenReturn(1);
        int result = userDao.checkLogin(user);
        assertEquals(result, 1);
    }
}