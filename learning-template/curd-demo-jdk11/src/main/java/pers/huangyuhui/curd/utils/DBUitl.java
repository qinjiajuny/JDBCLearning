package pers.huangyuhui.curd.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @project: curd-demo
 * @description: 数据库连接工具类
 * @author: 黄宇辉
 * @date: 8/22/2019-3:30 PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public class DBUitl {

    private static Connection connection;

    //获取数据库配置信息
    private static String URL = ConfigUtil.getProperties().getProperty("Url");
    private static String USER = ConfigUtil.getProperties().getProperty("UserName");
    private static String PASSWORD = ConfigUtil.getProperties().getProperty("UserPassword");
    private static String DRIVER_NAME = ConfigUtil.getProperties().getProperty("DriverName");

    //加载数据库驱动
    static {
        try {
            Class.forName(DRIVER_NAME);
        } catch (Exception e) {
            System.err.println("error: fail to init the driver of database");
            throw new ExceptionInInitializerError(e);
        }
    }

    //获取数据库连接
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}