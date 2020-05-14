import com.yan.dao.UserMapper;
import com.yan.pojo.User;
import com.yan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void Test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            //方式一：Mapper接口:获取Mapper接口的代理实现类对象
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user =  userMapper.getUserById(1);
/*方式二
        List<User> userList = sqlSession.selectList("com.yan.dao.UserMapper.getUserList");
*/
                System.out.println(user);
        } finally {
            sqlSession.close();
        }
    }
}