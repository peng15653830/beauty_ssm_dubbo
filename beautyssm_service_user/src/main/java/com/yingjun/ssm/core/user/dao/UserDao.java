package com.yingjun.ssm.core.user.dao;

import com.yingjun.ssm.api.user.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserDao {


    int insert(@Param("userName") String userName, @Param("userPhone") long userPhone, @Param("score") int score);

    int insert(@Param("user") User user);

    /**
     * 根据手机号查询用户对象
     *
     * @param userPhone
     * @return
     */
    User queryByPhone(long userPhone);


    /**
     * 根据偏移量查询用户列表
     *
     * @param offset
     * @param limit
     * @return
     */
    List<User> queryAll(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 增加积分
     */
    int addScore(@Param("add") int add);

    User get(Integer id);

    int update(User user);

    int checkLogin(User user);
}
