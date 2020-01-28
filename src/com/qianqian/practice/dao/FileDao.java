package com.qianqian.practice.dao;

import com.qianqian.practice.entity.FileInfo;

import java.util.List;

public interface FileDao {
    /**
     * 新增文件记录
     * @return
     */
    int insertFile(String fileId,int fileSize,String userId);

    /**
     * 根据userId获取该用户所有的FileDao集合
     */
    List<FileInfo> getFilesByUserId(String userId);
}
