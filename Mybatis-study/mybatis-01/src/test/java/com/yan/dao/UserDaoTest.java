package com.yan.dao;

import com.yan.bear.User;
import com.yan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
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
    public void Test(){
            SqlSession sqlSession = (SqlSession) MybatisUtils.getSqlSession();
            try{
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
    public void getUserLike(){
        SqlSession sqlSession =(SqlSession) MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserLike("%李%");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getUserId(){
        SqlSession sqlSession =  MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }


    @Test
    public void getUserId2(){
        SqlSession sqlSession =  MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id",4);
        mapper.getUserById2(map);
        sqlSession.commit();
        sqlSession.close();
    }

    //增删改需要增加事务
    @Test
    public void addUser(){
        SqlSession sqlSession =  MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.addUser(new User(4, "ly", "1111111"));
        if (res > 0){
            System.out.println("插入成功！");
        }
        sqlSession.commit();  //提交事务
        sqlSession.close();
    }

    @Test
    public void addUser2(){
       SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userid",5);
        map.put("username","hh");
        map.put("password","123456");
        mapper.addUser2(map);
        sqlSession.close();
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession =  MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.updateUser(new User(4,"hehhe","123123"));
        if (res > 0){
            System.out.println("修改成功！");
        }
        sqlSession.commit();  //提交事务
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int deleteUser = mapper.deleteUser(4);
        if (deleteUser > 0){
            System.out.println("删除成功！");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
