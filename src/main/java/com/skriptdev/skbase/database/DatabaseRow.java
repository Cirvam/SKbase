package com.skriptdev.skbase.database;

import java.util.Map;

/**
 * Represents a single row returned by a database query.
 */
public class DatabaseRow {

    private final Map<String, Object> data;

    /**
     * Creates a new database row.
     *
     * @param data Column names and their corresponding values
     */
    public DatabaseRow(Map<String, Object> data) {
        this.data = data;
    }

    /**
     * Gets a value from this row.
     *
     * @param column Column name
     * @return Value stored in the column, or null if the column does not exist
     */
    public Object get(String column) {
        return data.get(column);
    }

    /**
     * Gets a String value from this row.
     *
     * @param column Column name
     * @return String value, or null if the value is null
     */
    public String getString(String column) {
        Object value = get(column);

        return value != null ? value.toString() : null;
    }

    /**
     * Gets an integer value from this row.
     *
     * @param column Column name
     * @return Integer value, or null if the value is null
     */
    public Integer getInt(String column) {
        Object value = get(column);

        if (value == null) {
            return null;
        }

        if (value instanceof Number number) {
            return number.intValue();
        }

        return Integer.parseInt(value.toString());
    }

    /**
     * Gets a long value from this row.
     *
     * @param column Column name
     * @return Long value, or null if the value is null
     */
    public Long getLong(String column) {
        Object value = get(column);

        if (value == null) {
            return null;
        }

        if (value instanceof Number number) {
            return number.longValue();
        }

        return Long.parseLong(value.toString());
    }

    /**
     * Gets a double value from this row.
     *
     * @param column Column name
     * @return Double value, or null if the value is null
     */
    public Double getDouble(String column) {
        Object value = get(column);

        if (value == null) {
            return null;
        }

        if (value instanceof Number number) {
            return number.doubleValue();
        }

        return Double.parseDouble(value.toString());
    }

    /**
     * Gets a boolean value from this row.
     *
     * @param column Column name
     * @return Boolean value, or null if the value is null
     */
    public Boolean getBoolean(String column) {
        Object value = get(column);

        if (value == null) {
            return null;
        }

        if (value instanceof Boolean bool) {
            return bool;
        }

        if (value instanceof Number number) {
            return number.intValue() != 0;
        }

        return Boolean.parseBoolean(value.toString());
    }
}