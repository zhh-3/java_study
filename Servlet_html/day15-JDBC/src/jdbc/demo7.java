package jdbc;

import domain.User;
import util.Utils;

import java.sql.*;
import java.util.Scanner;

public class demo7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("用户名:");
        String username = scanner.nextLine();
        System.out.print("密码:");
        String password = scanner.nextLine();
        boolean login = new demo7().login(username, password);
        boolean login2 = new demo7().login2(username, password);
        if (login){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
        if (login2){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }

    public boolean login (String username, String password) {
        if (username == null || password == null){
            return false;
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet re = null;
        try {
            conn = Utils.getConnection();
            String sql = "select * from user where username = '"+username+"' and password ='"+password+"'";
            stmt = conn.createStatement();
            re = stmt.executeQuery(sql);
            return re.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Utils.close(stmt, conn, re);
        }
        return false;
    }
    public boolean login2 (String username, String password) {
        if (username == null || password == null){
            return false;
        }
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet re = null;
        try {
            conn = Utils.getConnection();
            String sql = "select * from user where username = ? and password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            re = pstmt.executeQuery();
            return re.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Utils.close(pstmt, conn, re);
        }
        return false;
    }
}
