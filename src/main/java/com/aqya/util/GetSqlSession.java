package com.aqya.util;/*
 @auther  wenqing
 @creat  2022-02-24 15:17
*/

/**
 * 获取SqlSession
 *
 * */


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class GetSqlSession {
    public static SqlSession  creatSqlSession() {
        InputStream resourceAsStream = null;
        SqlSessionFactory build = null;
        SqlSession sqlSession = null;
        try {
        //获得mybatis的环境变量
        String resource = "com/aqya/mybatis-config.xml";
        //以流的方式获取resource（mybatis的配置文件）
         resourceAsStream = Resources.getResourceAsStream (resource);

        //创建会话工厂
        build = new SqlSessionFactoryBuilder ().build (resourceAsStream);
        //通过工厂得到SqlSession
        sqlSession = build.openSession ();
        return sqlSession;
        } catch (IOException e) {
            e.printStackTrace ();
            return null;
        }
}

    public static void main(String[] args) {
        System.out.println ( creatSqlSession() );
    }

}
