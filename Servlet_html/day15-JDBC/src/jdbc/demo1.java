package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class demo1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");//可省略
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?serverTimezone=Asia/Shanghai", "root", "123456");

        String sql = "UPDATE account SET balance = 500 WHERE (id = 1)";
        Statement stmt = conn.createStatement();
        int count = stmt.executeUpdate(sql);

        System.out.println(count);
        stmt.close();
        conn.close();
    }
}
