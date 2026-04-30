package com.portfolio.datastructures.map;

import com.portfolio.datastructures.model.Student;

/**
 * A key-value pair used internally by the Hash Map.
 * Stores an integer key and its corresponding Student record, along with a
 * reference to the next entry in the bucket.
 *
 * @author Abdullah Al Asmy
 * @version 1.0
 */
public final class MapEntry
{
    private final int key;
    private Student value;
    private MapEntry next;

    /**
     * Constructs a new map entry with the specified key and value.
     *
     * @param key   the unique identifier for this entry
     * @param value the student record associated with the key
     * @throws IllegalArgumentException if the student value is null
     */
    public MapEntry(final int key,
                    final Student value)
    {
        if (value == null)
        {
            throw new IllegalArgumentException("MapEntry value cannot be null.");
        }

        this.key = key;
        this.value = value;
        this.next = null;
    }

    /**
     * Returns the integer key associated with this entry.
     *
     * @return the key
     */
    public int getKey()
    {
        return key;
    }

    /**
     * Returns the student record stored in this entry.
     *
     * @return the student value
     */
    public Student getValue()
    {
        return value;
    }

    /**
     * Updates the student record for this entry.
     *
     * @param value the new student record
     * @throws IllegalArgumentException if the new value is null
     */
    public void setValue(final Student value)
    {
        if (value == null)
        {
            throw new IllegalArgumentException("MapEntry value cannot be null.");
        }
        this.value = value;
    }

    /**
     * Returns the next entry in the collision chain.
     *
     * @return the next entry, or null if this is the end of the chain
     */
    public MapEntry getNext()
    {
        return next;
    }

    /**
     * Sets the pointer to the next entry in the collision chain.
     *
     * @param next the next entry to link
     */
    public void setNext(final MapEntry next)
    {
        this.next = next;
    }
}