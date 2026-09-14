package com.skriptdev.skbase.database;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DatabaseManager {

    private final Map<String, Database> databases = new HashMap<>();

    /**
     * Creates a new database manager.
     */
    public DatabaseManager() {
    }

    /**
     * Registers a database with the manager.
     *
     * @param name The name used to identify the database.
     * @param database The database to register.
     */
    public void register(String name, Database database) {
        databases.put(name, database);
    }

    /**
     * Gets a registered database.
     *
     * @param name The name of the database.
     * @return The registered database, or null if it does not exist.
     */
    public Database get(String name) {
        return databases.get(name);
    }

    /**
     * Connects to all registered databases.
     *
     * @throws SQLException If a database cannot be connected.
     */
    public void connectAll() throws SQLException {
        for (Database database : databases.values()) {
            database.connect();
        }
    }

    /**
     * Disconnects from all registered databases.
     *
     * @throws SQLException If a database cannot be disconnected.
     */
    public void disconnectAll() throws SQLException {
        for (Database database : databases.values()) {
            database.disconnect();
        }
    }

    /**
     * Initialize all databases
     *
     * @throws SQLException If a database cannot be initialized.
     */
    public void initializeAll() throws SQLException {
        for (Database database : databases.values()) {
            database.initialize();
        }
    }
}

