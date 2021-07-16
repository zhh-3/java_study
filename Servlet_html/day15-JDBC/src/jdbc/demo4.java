package jdbc;

import java.sql.*;

public class demo4 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet re = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//可省略
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?serverTimezone=Asia/Shanghai", "root", "123456");

            String sql = "select * from account";
            stmt = conn.createStatement();
            re = stmt.executeQuery(sql);
            while (re.next()){
                int id = re.getInt(1);
                String name = re.getString("name");
                double balance = re.getDouble("balance");
                System.out.println(id+"---"+name+"----"+balance);
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
            if (re != null){
                try {
                    re.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
