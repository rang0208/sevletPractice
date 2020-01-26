package com.qianqian.practice.entity;

/**
 * 用户实体
 */
public class User {
    private String userId;
    private String userName;
    private String userPassword;
    private String userGender;

    public User() {

    }

    public User(String userId, String userName, String userPassword, String userGender) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userGender = userGender;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userGender='" + userGender + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
}
