import com.sun.org.slf4j.internal.LoggerFactory;
import com.yan.dao.UserMapper;
import com.yan.pojo.User;
import com.yan.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import	java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class UserMapperTest {

    static  Logger log = Logger.getLogger(String.valueOf(UserMapperTest.class));
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

    @Test
    public void testLog4j(){
      log.info("info:进入了log4j方法");
      log.fine("fine:进入了log4j方法");
    }

    //分页
    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> userList = mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    //分页2
    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RowBounds rowBounds = new RowBounds(1, 2);
        List<User> userList = sqlSession.selectList("com.yan.dao.UserMapper.getUserByRowBounds",null,rowBounds);

        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
