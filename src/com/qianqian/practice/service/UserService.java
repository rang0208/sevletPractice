package com.qianqian.practice.service;

import com.qianqian.practice.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 查询用户名是否存在
     */
    boolean checkUserName(String userName);

    /**
     * 登陆检查
     */
    boolean loginCheck(String userName, String userPassword);

    /**
     * 根据用户名和密码获取用户唯一ID
     */
    String getUserIdByNameAndPassWord(String userName, String userPassword);

    /**
     * 插入用户
     */
    boolean insertUser(String userId, String userName, String userPassword, String userGender);

    /**
     * 根据用户唯一ID删除用户
     */
    boolean deleteUser(String userId);

    /**
     * 更新用户信息
     */
    boolean updateUser(String userId, String userName, String userPassword, String userGender);

    /**
     * 根据用户唯一ID获取用户
     */
    User getUser(String userId);

    /**
     * 获取用户列表
     *
     * @return
     */
    List<User> getAllUsers();

    /**
     * 获取所有用户数量
     */
    int getAllUserNum();

    /**
     * 根据页码和页大小获取对应的用户数据
     *
     * @param pageNumber 页码
     * @return
     */
    List<User> getUserListByPage(int pageNumber);
}
