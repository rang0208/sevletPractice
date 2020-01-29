package com.qianqian.practice.entity;

public class FileInfo {
    private String fileId;
    private String fileName;
    private String fileUploadDate;
    private int fileSize;
    //文件所属用户id
    private String userId;

    public FileInfo() {
    }

    public FileInfo(String fileId, String fileName, String fileUploadDate, int fileSize, String userId) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileUploadDate = fileUploadDate;
        this.fileSize = fileSize;
        this.userId = userId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    @Override
    public String toString() {
        return "FileInfo{" +
                "fileId='" + fileId + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileUploadDate='" + fileUploadDate + '\'' +
                ", fileSize=" + fileSize +
                ", userId='" + userId + '\'' +
                '}';
    }
}
