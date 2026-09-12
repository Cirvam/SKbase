package com.skriptdev.skbase.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDatabase implements Database {


    private final String databasePath;
    private Connection connection;


    /**
     * Create a new SQLite database
     *
     * @param databasePath Path to the database file
     */
    public SQLiteDatabase(String databasePath) {
        this.databasePath = databasePath;
    }



    @Override
    public void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + databasePath);
    }


    @Override
    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

}

