package br.com.wel.db.application;

import br.com.wel.db.DB;
import br.com.wel.db.exeception.DbException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Transactions {

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DB.getConnection();

            conn.setAutoCommit(false);

            st = conn.createStatement();

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2100 WHERE DepartmentId = 1");
            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3100 WHERE DepartmentId = 2");

            //int x = 1;
            //if (x < 2){
            //   throw new SQLException("Fake error");
            //}

            System.out.println("rows1 " + rows1);
            System.out.println("rows2 " + rows2);

        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
