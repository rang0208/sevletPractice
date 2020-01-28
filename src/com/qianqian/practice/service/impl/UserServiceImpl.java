package com.qianqian.practice.service.impl;

import com.qianqian.practice.dao.UserDao;
import com.qianqian.practice.dao.impl.UserDaoImpl;
import com.qianqian.practice.entity.User;
import com.qianqian.practice.service.UserService;
import com.qianqian.practice.utils.ConfigUtils;

import java.util.List;
import java.util.Properties;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean checkUserName(String userName) {
        return userDao.checkUserName(userName);
    }

    @Override
    public boolean loginCheck(String userName, String userPassword) {
        return userDao.loginCheck(userName, userPassword);
    }

    @Override
    public String getUserIdByNameAndPassWord(String userName, String userPassword) {
        return userDao.getUserIdByNameAndPassWord(userName,userPassword);
    }

    @Override
    public boolean insertUser(String userId, String userName, String userPassword, String userGender) {
        User user = new User(userId, userName, userPassword, userGender);
        int i = userDao.insertUser(user);
        if (i != 0) return true;
        return false;
    }

    @Override
    public boolean deleteUser(String userId) {
        int i = userDao.deleteUser(userId);
        if (i != 0) return true;
        return false;
    }

    @Override
    public boolean updateUser(String userId, String userName, String userPassword, String userGender) {
        User user = new User(userId, userName, userPassword, userGender);
        int i = userDao.updateUser(user);
        if (i != 0) return true;
        return false;
    }

    @Override
    public User getUser(String userId) {
        return userDao.getUser(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public int getAllUserNum() {
        return userDao.getAllUserNum();
    }

    @Override
    public List<User> getUserListByPage(int pageNumber) {
        //获取配置文件对象
        Properties globalProperties = ConfigUtils.getGlobalProperties();
        //获取配置中的每页的大小
        int pageSize = Integer.parseInt(globalProperties.getProperty("pageSize"));
        //获取当前页码的第一条索引位置
        int pageIndex = (pageNumber - 1) * pageSize;
        return userDao.getUserListByPage(pageIndex, pageSize);
    }
}
