package com.qianqian.practice.utils;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 工具类
 */
public class DBUtils {
    private static DruidDataSource druidDataSource = null;
    //单线程连接map
//    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    static {
        InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("database.properties");
        Properties properties = new Properties();
        try {
            //获取配置文件对象
            properties.load(inputStream);
            //获取druid数据库连接池
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池
     */
    public static DruidDataSource getDruidDataSource() {
        return druidDataSource;
    }
    /*
     *//**
     * 获取数据库连接（确保每次使用的是同一个连接）
     *//*
    public static Connection getConnection() {
        Connection connection=null;
        try {
            connection=connectionThreadLocal.get();
            //判断此线程中是否已经有连接对象
            if (connection == null) {
                connection = druidDataSource.getConnection();
                connectionThreadLocal.set(connection);
            }
        } catch (SQLException e) {
            System.err.println("获取数据库连接失败");
        }
        return connection;
    }

    *//**
     * 关闭数据库连接
     *//*
    public static void close() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    *//**
     * 开始数据库事务
     *//*
    public static void startTransaction() {
        try {
            getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    *//**
     * 提交事务
     *//*
    public static void commitAndClose() {
        try {
            Connection connection = getConnection();
            connection.commit();
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    *//**
     * 回滚事务
     *//*
    public static void rollbackAndClose() {
        try {
            Connection connection = getConnection();
            connection.rollback();
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
