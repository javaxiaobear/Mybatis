import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MybatisUtils;


public class MyTest {

    @Test
    public void queryUsersById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userList = mapper.queryUsersById(1);
        System.out.println(userList);
        System.out.println("================");
        User userList2 = mapper.queryUsersById(1);
        System.out.println(userList2==userList);
        sqlSession.close();
    }
}
