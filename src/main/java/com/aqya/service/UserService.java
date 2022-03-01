package com.aqya.service;/*
 @auther  wenqing
 @creat  2022-02-26 16:06
*/

import com.aqya.entity.User;
import com.aqya.entity.vo.MessageModel;
import com.aqya.mapper.UserMapper;
import com.aqya.util.GetSqlSession;
import com.aqya.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *  用户登录
 *
 */


public class UserService {

    /**
     *    1、参数的非空判断
*            如果为空，将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
*         2、调用Dao的查询方法，通过用户名查询用户对象
*         3、判断用户对象是否为空
*            如果为空 将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
*         4、判断数据库查询到的用户密码与前台传递的密码比较
*           如果不相等， 将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
*         5、登入成功，将成功状态码、提示信息、用户对象设置消息模型对象，并return
     * @param username
     * @param userpwd
     * @return
     */



    public MessageModel userlogin(String username, String userpwd) {
        MessageModel messageModel = new MessageModel ();

        //回显数据设置到消息模型对象中，
        User u = new User();
        u.setUserName (username);
        u.setUserPwd (userpwd);

        messageModel.setObject (u);

        // 1、参数的非空判断
        if(StringUtil.isEmpty(username) || StringUtil.isEmpty(userpwd)){
            //如果为空，将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象

            messageModel.setCode (0);
            messageModel.setMsg ("用户姓名和密码不能为空");
            return messageModel;

    }

        //2、调用Dao的查询方法，通过用户名查询用户对象
        SqlSession sqlSession = GetSqlSession.creatSqlSession ();
        UserMapper mapper = sqlSession.getMapper (UserMapper.class);
        User user = mapper.queryUserByName (username);
     //   System.out.println (user);
        //3、判断用户对象是否为空
        if(user == null){
            messageModel.setCode (0);
            messageModel.setMsg ("用户不存在");
            return messageModel;
    }

        // 4、判断数据库查询到的用户密码与前台传递的密码比较
        if(!userpwd.equals (user.getUserPwd ())) {
            //如果不相等， 将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            if (user != null) {
                messageModel.setCode (0);
                messageModel.setMsg ("用户密码不正确");
                return messageModel;
            }

        }
        //5、登入成功，将用户信息设置到信息模型中
        messageModel.setObject (user);

        return messageModel;
    }
}
