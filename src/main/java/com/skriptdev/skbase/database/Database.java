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

    /**
     * Initializes the database schema
     *
     * @throws SQLException
     */
    void initialize() throws SQLException;


    /**
     * Executes and SQL update statement.
     *
     * @param sql SQL Statement to execute
     * @param parameters Parameters to bind to the prepared statement
     * @return The number of rows that are affected.
     * @throws SQLException If the statement is unable to be executed.
     */
    int executeUpdate(String sql, Object... parameters) throws SQLException;


    DatabaseResult query(String sql, Object... parameters) throws SQLException;




}
