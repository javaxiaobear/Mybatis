package mapper;


import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;

public interface UserMapper {

    User queryUsersById(@Param("id") int id);
}
