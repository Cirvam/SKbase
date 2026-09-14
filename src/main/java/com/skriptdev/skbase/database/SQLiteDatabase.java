package com.skriptdev.skbase.database;



import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public void initialize() throws SQLException {



    }

    @Override
    public int executeUpdate(String sql, Object... parameters) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            for (int i = 0; i < parameters.length; i++) {
                statement.setObject(i + 1, parameters[i]);
            }
            return statement.executeUpdate();
        }
    }


    /**
     * Executes a SQL query against the SQLite database.
     *
     * @param sql SQL query to execute
     * @param parameters Parameters to bind to the prepared statement
     * @return Database result containing the returned rows
     * @throws SQLException if the query cannot be executed
     */
    @Override
    public DatabaseResult query(String sql, Object... parameters) throws SQLException {
        List<DatabaseRow> results = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            for (int i = 0; i < parameters.length; i++) {
                statement.setObject(i + 1, parameters[i]);
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                ResultSetMetaData metadata = resultSet.getMetaData();
                int columnCount = metadata.getColumnCount();

                while (resultSet.next()) {
                    Map<String, Object> rowData = new HashMap<>();

                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metadata.getColumnName(i);
                        Object value = resultSet.getObject(i);

                        rowData.put(columnName, value);
                    }

                    results.add(new DatabaseRow(rowData));
                }
            }
        }

        return new DatabaseResult(results);
    }
}

