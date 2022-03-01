package com.aqya.Test;/*
 @auther  wenqing
 @creat  2022-02-24 16:39
*/

import com.aqya.entity.User;
import com.aqya.mapper.UserMapper;
import com.aqya.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

public class Test {
    public static void main(String[] args){
        //获取sqlSession对象
        SqlSession sqlSession = GetSqlSession.creatSqlSession ();
        //得到对应Mapper
        UserMapper userMapper = sqlSession.getMapper (UserMapper.class);
        //调用方法
        User admin = userMapper.queryUserByName ("admin");
        System.out.println (admin);
    }
}
