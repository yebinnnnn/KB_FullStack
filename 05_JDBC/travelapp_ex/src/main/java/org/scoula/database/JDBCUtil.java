package org.scoula.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

    static Properties prop=new Properties();
//    private static String url;
//    private static String user;
//    private static String password;
//    private static String driver;
//
//    static {
//        try {
//            prop.load(JDBCUtil.class.getResourceAsStream("/application.properties"));
//            driver = prop.getProperty("driver");
//            url = prop.getProperty("url");
//            user = prop.getProperty("user");
//            password = prop.getProperty("password");
//
//            Class.forName(driver);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static Connection getConnection() {
//        try {
//            conn=DriverManager.getConnection(url, user, password);
//            return conn;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
    static Connection conn=null;
//
    public static void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    static {
        try {
            Properties prop = new Properties();
            // /application.properties는 classpath경로를 말한다
            prop.load(JDBCUtil.class.getResourceAsStream("/application.properties"));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return conn;
    }


}