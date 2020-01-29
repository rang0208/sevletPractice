package com.qianqian.practice.test;

import com.qianqian.practice.dao.FileDao;
import com.qianqian.practice.dao.impl.FileDaoImpl;

/**
 * 用于对项目模块进行测试
 */
public class Test {


    public Test() {

    }

    public static void main(String[] args) {
        FileDao fileDao = new FileDaoImpl();
        System.out.println(fileDao.getFileStorageName("d3929c18-7558-4bdc-9759-a969af5e27a2"));
    }
}
