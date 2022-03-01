package com.aqya.entity;/*
 @auther  wenqing
 @creat  2022-02-24 14:23
*/

    /**
     *User实体类
     *
     *
     * */

public class User {
    private Integer userID;
    private String userName;
    private String userPwd;
    private Integer  UserAge;

        public Integer getUserID() {
            return userID;
        }

        public void setUserID(Integer userID) {
            this.userID = userID;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPwd() {
            return userPwd;
        }

        public void setUserPwd(String userPwd) {
            this.userPwd = userPwd;
        }

        public Integer getAge() {
            return UserAge;
        }

        public void setAge(Integer age) {
            this.UserAge = age;
        }
    }
