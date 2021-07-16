package jdbc;

import domain.account;
import util.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class demo6 {
    public static void main(String[] args) {
        List<account> list = new demo6().findAll();
        System.out.println(list);
        System.out.println(list.size());
    }

    public List<account> findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet re = null;
        List<account> list = null;
        try {
            conn = Utils.getConnection();
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Utils.close(stmt, conn, re);
        }

        return list;
    }
}
