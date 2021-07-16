package Itcast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //注册
        Class.forName("com.mysql.cj.jdbc.Driver");

        //获取连接对象
        Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dbem?serverTimezone=UTC", "root", "123456");

        //定义sql语句
        String sql1 = "insert into salary2 VALUES(";

        //获取执行sql语句的对象 statement
        Statement stmt = conn.createStatement();

        //执行sql
        for (int i = 0; i < 500000; i++) {
            String sql2 = i+",100,100)";
            String sql = sql1 + sql2;
            stmt.executeUpdate(sql);
        }

        //释放资源
        stmt.close();
        conn.close();
    }
}
