package com.qianqian.practice.service.impl;

import com.qianqian.practice.dao.FileDao;
import com.qianqian.practice.dao.impl.FileDaoImpl;
import com.qianqian.practice.entity.FileInfo;
import com.qianqian.practice.service.FileService;

import java.util.List;

public class FileServiceImpl implements FileService {
    FileDao fileDao=new FileDaoImpl();
    @Override
    public boolean insertFile(String fileId, int fileSize, String userId) {
        int i=fileDao.insertFile(fileId,fileSize,userId);
        if(i!=0) return true;
        return false;
    }

    @Override
    public List<FileInfo> getFilesByUserId(String userId) {
        return fileDao.getFilesByUserId(userId);
    }
}
