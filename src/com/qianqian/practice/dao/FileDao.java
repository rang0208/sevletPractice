package com.qianqian.practice.dao;

import com.qianqian.practice.entity.FileInfo;

import java.util.List;

public interface FileDao {
    /**
     * 新增文件记录
     *
     * @return
     */
    int insertFile(String fileId, String fileName, int fileSize, String userId);

    /**
     * 根据fileId获取文件名，并返回fileId+fileName
     */
    String getFileStorageName(String userId);

    /**
     * 删除指定fileId的文件记录
     */
    boolean deleteFileByFileId(String fileId);

    /**
     * 根据userId获取该用户所有的FileDao集合
     */
    List<FileInfo> getFilesByUserId(String userId);
}
