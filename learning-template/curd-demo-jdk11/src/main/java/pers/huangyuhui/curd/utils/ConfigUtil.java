package pers.huangyuhui.curd.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @project: curd-demo
 * @description: 读取数据库配置文件的工具类
 * @author: 黄宇辉
 * @date: 8/22/2019-3:49 PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
class ConfigUtil {

    private ConfigUtil() { }

    private static Properties properties;
    // 读取数据库配置文件
    private static InputStream inputStream = ConfigUtil.class.getResourceAsStream("/db.properties");

    static {
        try {
            properties = new Properties();
            properties.load(inputStream);
            properties.getProperty("Url");
            properties.getProperty("UserName");
            properties.getProperty("UserPassword");
            properties.getProperty("DriverName");
        } catch (FileNotFoundException e) {
            System.err.println("error: not found db.properties file");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //获取数据库配置
    static Properties getProperties() { return properties; }
}
