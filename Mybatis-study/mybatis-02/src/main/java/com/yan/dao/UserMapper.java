package com.yan.dao;
import com.yan.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();
    //根据id查询
    User getUserById(int id);
    //inset一个用户
    int addUser(User user);
    //修改用户
    int updateUser(User user);
    //删除用户
    int deleteUser(int id);
}
