package com.qianqian.practice.dao.impl;

import com.qianqian.practice.dao.UserDao;
import com.qianqian.practice.entity.User;
import com.qianqian.practice.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    //数据库操作工具
    private QueryRunner queryRunner = new QueryRunner(DBUtils.getDruidDataSource());

    @Override
    public boolean checkUserName(String userName) {
        try {
            User user = queryRunner.query("select*from tb_userlogininfo where userName=?", new BeanHandler<>(User.class), userName);
            if (user != null) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean loginCheck(String userName, String userPassword) {
        try {
            User user = queryRunner.query("select*from tb_userlogininfo where userName=? and userPassword=?", new BeanHandler<>(User.class), userName, userPassword);
            if (user != null) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public int insertUser(User user) {
        try {
            return queryRunner.update("insert into tb_userlogininfo (userId,userName,userPassword,userGender) values(?,?,?,?)", user.getUserId(), user.getUserName(), user.getUserPassword(), user.getUserGender());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteUser(String userId) {
        try {
            return queryRunner.update("delete from tb_userlogininfo where userId=?", userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateUser(User user) {
        Object[] objects = {user.getUserName(), user.getUserPassword(), user.getUserGender(), user.getUserId()};
        try {
            return queryRunner.update("update tb_userlogininfo set userName=?,userPassword=?,userGender=? where userId=?", objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public User getUser(String userId) {
        try {
            return queryRunner.query("select*from tb_userlogininfo where userId=?", new BeanHandler<User>(User.class), userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        try {
            List<User> userList = queryRunner.query("select*from tb_userlogininfo;", new BeanListHandler<>(User.class));
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getAllUserNum() {
        try {
            //默认返回类型为long
            long l=queryRunner.query("select count(*) from tb_userlogininfo",new ScalarHandler<>());
            int i= (int) l;
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<User> getUserListByPage(int pageIndex, int pageSize) {
        try {
            return queryRunner.query("select*from tb_userlogininfo limit ?,?",new BeanListHandler<>(User.class),pageIndex,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
