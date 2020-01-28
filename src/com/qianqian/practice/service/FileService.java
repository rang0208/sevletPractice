package com.qianqian.practice.service;

import com.qianqian.practice.entity.FileInfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public interface FileService {
    /**
     * 插入文件信息
     */
    boolean insertFile(String fileId, int fileSize,String userId);

    /**
     *根据用户id查询所有的文件
     */
    List<FileInfo> getFilesByUserId(String userId);
}
