package com.qianqian.practice.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 有关文件操作（上传下载）的工具类
 */
public class FileUtils {
    /**
     * 使用UUID将文件名装饰成唯一表示
     * @param fileName
     * @return
     */
    public static String addUUIDtoFileName(String fileName){
        return UUID.randomUUID().toString().replaceAll("-","")+"##"+fileName;
    }

    /**
     * 对要上传的文件进行过滤
     */
    public static boolean checkExtension(String fileName){
        List<String> extensionNameString=new ArrayList<>();
        extensionNameString.add("jpg");
        extensionNameString.add("png");
        extensionNameString.add("txt");
        extensionNameString.add("java");

        for(String string:extensionNameString){
            if (fileName.endsWith(string)) return true;
        }
        return false;
    }



}
