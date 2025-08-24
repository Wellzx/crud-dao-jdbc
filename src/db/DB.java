package br.com.wel.db;

import br.com.wel.db.exeception.DbException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    public static synchronized Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("db.url");

                Properties jdbcProps = new Properties();
                jdbcProps.setProperty("user", props.getProperty("db.user"));
                jdbcProps.setProperty("password", props.getProperty("db.password"));
                jdbcProps.setProperty("ssl", props.getProperty("useSSL", "false"));

                conn = DriverManager.getConnection(url, jdbcProps);

            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }

        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            } finally {
                conn = null;
            }
        }
    }

    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;

        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }

        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
