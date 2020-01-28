package com.qianqian.practice.dao.impl;

import com.qianqian.practice.dao.FileDao;
import com.qianqian.practice.entity.FileInfo;
import com.qianqian.practice.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class FileDaoImpl implements FileDao {
    QueryRunner queryRunner=new QueryRunner(DBUtils.getDruidDataSource());

    @Override
    public int insertFile(String fileId, int fileSize, String userId) {
        try {
            return queryRunner.update("insert into tb_fileinfo (fileId,fileSize,userId) values (?,?,?)",fileId,fileSize,userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<FileInfo> getFilesByUserId(String userId) {
        try {
            return queryRunner.query("select*from tb_fileinfo where userId=?",new BeanListHandler<>(FileInfo.class),userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
