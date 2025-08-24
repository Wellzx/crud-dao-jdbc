package br.com.wel.db.application;

import br.com.wel.db.DB;
import br.com.wel.db.exeception.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "DELETE FROM seller "
                    + "WHERE "
                    + "Id = ?");

            st.setInt(1,9);

            int rowsAffected = st.executeUpdate();
            System.out.println("DONE! Rows affected: " + rowsAffected);


        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
