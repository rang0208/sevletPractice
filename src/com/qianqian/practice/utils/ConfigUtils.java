package com.qianqian.practice.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 有关项目配置的工具
 */
public class ConfigUtils {
    //获取配置文件对象
    public static Properties getGlobalProperties() {
        InputStream inputStream = ConfigUtils.class.getClassLoader().getResourceAsStream("global_config.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
