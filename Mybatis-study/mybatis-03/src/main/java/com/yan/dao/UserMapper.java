package com.yan.dao;
import com.yan.pojo.User;

import java.util.List;

public interface UserMapper {

    //根据id查询
    User getUserById(int id);
}
