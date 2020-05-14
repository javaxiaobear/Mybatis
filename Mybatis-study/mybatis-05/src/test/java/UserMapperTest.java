import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import yan.dao.UserMapper;
import yan.pojo.User;
import yan.utils.MybatisUtils;

import java.lang.annotation.Target;
import java.util.List;

/**
 * @Classname UserMapperTest
 * @Description TODO
 * @Date 2020/2/20 0020 19:39
 * @Created by Administrator
 */
public class UserMapperTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //设置分页信息
        Page<Object> page = PageHelper.startPage(0, 1);
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println(page.getTotal());
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(5);
        System.out.println(userById);

        sqlSession.close();
    }
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(6,"hhh","123123"));
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(6,"hufhu","123123"));
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(6);
        sqlSession.close();
    }

}
