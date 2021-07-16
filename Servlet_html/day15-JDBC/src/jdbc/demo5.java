package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import domain.account;

public class demo5 {
    public static void main(String[] args) {
        List<account> list = new demo5().findAll();
        System.out.println(list);
        System.out.println(list.size());
    }

    public List<account> findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet re = null;
        List<account> list = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?serverTimezone=Asia/Shanghai", "root", "123456");
            String sql = "select * from account";
            stmt = conn.createStatement();
            re = stmt.executeQuery(sql);
            account account = null;
            list = new ArrayList<account>();
            while (re.next()){
                int id = re.getInt(1);
                String name = re.getString(2);
                int balance = re.getInt(3);
                account = new account();
                account.setId(id);
                account.setName(name);
                account.setBalance(balance);
                list.add(account);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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

        return list;
    }
}
