import com.yan.dao.UserMapper;
import com.yan.pojo.User;
import com.yan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname UserDaoTest
 * @Description TODO
 * @Date 2020/2/18 0018 21:18
 * @Created by Administrator
 */
public class UserDaoTest {

    @Test
    public void Test() {
        SqlSession sqlSession = (SqlSession) MybatisUtils.getSqlSession();
        try {
            //方式一：Mapper接口:获取Mapper接口的代理实现类对象
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();
            //方式二
/*
        List<User> userList = sqlSession.selectList("com.yan.dao.UserMapper.getUserList");
*/
            for (User user : userList) {
                System.out.println(user);
            }
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void getUserLike() {
        SqlSession sqlSession = (SqlSession) MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}