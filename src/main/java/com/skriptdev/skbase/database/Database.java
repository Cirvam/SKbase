package com.skriptdev.skbase.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface Database {

    /**
     * Establishes connection to database
     *
     * @throws SQLException If connection cannot be established
     */
    void connect() throws SQLException;


    /**
     * Disconnects from database
     *
     * @throws SQLException If connection cannot be closed.
     */
    void disconnect() throws SQLException;


    /**
     * Gets current database connection
     *
     * @return the active database connection
     */
    Connection getConnection();

}
