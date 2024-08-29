package com.capitainfoxy.worldtransformer.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtils {

    private static Connection connection;

    public static void initializeDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:world_transformer.db");
            Statement statement = connection.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS snapshots (world_name TEXT, data TEXT)";
            statement.execute(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
