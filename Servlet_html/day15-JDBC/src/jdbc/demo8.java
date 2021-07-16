package jdbc;

import util.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class demo8 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            conn = Utils.getConnection();
            conn.setAutoCommit(false);
            String sql1 = "update account set balance = balance - ? where id = ?";
            String sql2 = "update account set balance = balance + ? where id = ?";
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            pstmt1.setInt(1, 500);
            pstmt1.setInt(2, 2);
            pstmt2.setInt(1, 500);
            pstmt2.setInt(2, 4);
            pstmt1.executeUpdate();
//            int i = 3/0;
            pstmt2.executeUpdate();
            conn.commit();
        } catch (SQLException throwables) {
            try {
                if (conn != null)
                    conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }finally {
            Utils.close(pstmt1, conn);
            Utils.close(pstmt2, null);
        }
    }

}
