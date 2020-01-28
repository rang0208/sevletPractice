package com.qianqian.practice.entity;

public class FileInfo {
    private String fileId;
    private String fileUploadDate;
    private int fileSize;
    //文件所属用户id
    private String userId;

    public FileInfo() {
    }

    public FileInfo(String fileId, String fileUploadDate, int fileSize, String userId) {
        this.fileId = fileId;
        this.fileUploadDate = fileUploadDate;
        this.fileSize = fileSize;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "fileId='" + fileId + '\'' +
                ", fileUploadDate='" + fileUploadDate + '\'' +
                ", fileSize=" + fileSize +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileUploadDate() {
        return fileUploadDate;
    }

    public void setFileUploadDate(String fileUploadDate) {
        this.fileUploadDate = fileUploadDate;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
