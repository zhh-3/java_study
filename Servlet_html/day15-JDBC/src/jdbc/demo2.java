package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class demo2 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//可省略
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?serverTimezone=Asia/Shanghai", "root", "123456");

            String sql1 = "INSERT INTO account values(null,'王五',3000)";
            String sql2 = "UPDATE account SET balance = 500";
            String sql3 = "DELETE from account where id = 1";
            stmt = conn.createStatement();
            int count1 = stmt.executeUpdate(sql1);
            if (count1 > 0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
            int count2 = stmt.executeUpdate(sql2);
            if (count2 > 0){
                System.out.println("更新成功");
            }else {
                System.out.println("更新失败");
            }
            int count3 = stmt.executeUpdate(sql3);
            if (count3 > 0){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
