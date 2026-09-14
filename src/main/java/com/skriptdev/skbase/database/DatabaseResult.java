package com.skriptdev.skbase.database;

import java.util.List;
import java.util.Iterator;

/**
 * Represents the results returned by a database query.
 */
public class DatabaseResult implements Iterable<DatabaseRow> {

    private final List<DatabaseRow> rows;

    /**
     * Creates a new database result.
     *
     * @param rows Rows returned by the database query
     */
    public DatabaseResult(List<DatabaseRow> rows) {
        this.rows = rows;
    }

    /**
     * Gets all rows returned by the query.
     *
     * @return List of result rows
     */
    public List<DatabaseRow> getRows() {
        return rows;
    }

    /**
     * Gets the number of rows returned by the query.
     *
     * @return Number of rows
     */
    public int size() {
        return rows.size();
    }

    /**
     * Checks whether the query returned any rows.
     *
     * @return True if no rows were returned
     */
    public boolean isEmpty() {
        return rows.isEmpty();
    }

    @Override
    public Iterator<DatabaseRow> iterator() {
        return rows.iterator();
    }

}