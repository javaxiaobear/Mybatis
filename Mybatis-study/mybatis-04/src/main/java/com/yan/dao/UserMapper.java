package com.yan.dao;
import com.yan.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //根据id查询
    User getUserById(int id);

    //分页
    List<User> getUserByLimit(Map<String, Object> map);

    //分页2
    List<User> getUserByRowBounds();
}
