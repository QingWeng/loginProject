package com.aqya.mapper;/*
 @auther  wenqing
 @creat  2022-02-24 14:42
*/

import com.aqya.entity.User;

public interface  UserMapper{
    public User queryUserByName(String userName);
}
