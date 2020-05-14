package com.yan.dao;

import com.yan.bear.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    //模糊查询
    List<User> getUserLike(String name);

    //根据id查询
    User getUserById(int id);

    User getUserById2(Map<String,Object> map);

    //inset一个用户
    int addUser(User user);

    int addUser2(Map<String,Object> map);

    //修改用户
    int updateUser(User user);
    //删除用户
    int deleteUser(int id);
}
