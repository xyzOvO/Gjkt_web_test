package com.xyz66.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtils {

    private static DataSource dataSource = null;
    private static Properties properties = null;

    static{
        properties = new Properties();
        try {
            //将配置文件加载进入内存，采用反射技术
            properties.load(DruidUtils.class.getClassLoader().getResourceAsStream(""));
            //通过工厂设计模式得到一个连接池对象，得到的是一个连接池对象，而不是连接对象哦
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException("连接池配置文件加载失败");
        }
    }
    //将连接池对象开放给外部使用
    public static DataSource getDataSource(){
        return dataSource;
    }
    //从连接池对象中获取Connection
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
