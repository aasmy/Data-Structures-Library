package com.portfolio.datastructures.map;

import com.portfolio.datastructures.model.Student;

/**
 * A Hash Map implementation for storing and retrieving Student records using ID as the key.
 *
 * @author Abdullah Al Asmy
 * @version 1.0
 */
public class StudentHashMap
{
    private static final int DEFAULT_CAPACITY = 16;
    private static final int EMPTY_SIZE = 0;

    private final MapEntry[] buckets;
    private int size;

    /**
     * Constructs an empty Hash Map.
     */
    public StudentHashMap()
    {
        this.buckets = new MapEntry[DEFAULT_CAPACITY];
        this.size = EMPTY_SIZE;
    }

    /**
     * Constructs an empty Hash Map.
     *
     * @param capacity the number of buckets to initialize
     * @throws IllegalArgumentException if the capacity is less than 1
     */
    public StudentHashMap(final int capacity)
    {
        if (capacity < 1)
        {
            throw new IllegalArgumentException("Hash Map capacity must be at least 1.");
        }

        this.buckets = new MapEntry[capacity];
        this.size = EMPTY_SIZE;
    }

    /**
     * Calculates the target bucket index for the specified key.
     *
     * @param key the integer key to hash
     * @return the computed bucket index
     */
    private int hash(final int key)
    {
        return Math.abs(key) % buckets.length;
    }

    /**
     * Adds the student to the map using their ID as the unique key.
     * If a record with this ID already exists in the map, it is overwritten
     * with the new student object.
     *
     * @param student the student record to insert
     * @throws IllegalArgumentException if the student is null
     */
    public void put(final Student student)
    {
        if (student == null)
        {
            throw new IllegalArgumentException("Cannot insert a null student into the Hash Map.");
        }

        final int key = student.getNumber();
        final int index = hash(key);

        MapEntry current = buckets[index];

        if (current == null)
        {
            buckets[index] = new MapEntry(key, student);
            size++;
            return;
        }

        while (true)
        {
            if (current.getKey() == key)
            {
                current.setValue(student);
                return;
            }

            if (current.getNext() == null)
            {
                current.setNext(new MapEntry(key, student));
                size++;
                return;
            }

            current = current.getNext();
        }
    }

    /**
     * Gets a student by their ID.
     *
     * @param studentNumber the ID number to search for
     * @return the matching Student object, or null if no match is found
     */
    public Student get(final int studentNumber)
    {
        final int index = hash(studentNumber);
        MapEntry current = buckets[index];

        while (current != null)
        {
            if (current.getKey() == studentNumber)
            {
                return current.getValue();
            }
            current = current.getNext();
        }

        return null;
    }

    /**
     * Removes a student from the map using their ID number.
     *
     * @param studentNumber the ID number of the student to remove
     * @return the removed Student object, or null if no match is found
     */
    public Student remove(final int studentNumber)
    {
        final int index = hash(studentNumber);

        MapEntry current = buckets[index];
        MapEntry previous = null;

        while (current != null)
        {
            if (current.getKey() == studentNumber)
            {
                if (previous == null)
                {
                    buckets[index] = current.getNext();
                }
                else
                {
                    previous.setNext(current.getNext());
                }

                size--;
                return current.getValue();
            }

            previous = current;
            current = current.getNext();
        }

        return null;
    }

    /**
     * Prints the contents of the hash map to the console, organized by bucket.
     */
    public void printMap()
    {
        System.out.println("--- Hash Map Distribution ---");

        for (int i = 0; i < buckets.length; i++)
        {
            System.out.print("Bucket " + i + ": ");

            MapEntry current = buckets[i];

            if (current == null)
            {
                System.out.println("Empty");
            }
            else
            {
                while (current != null)
                {
                    System.out.print("[" + current.getKey() + " -> " + current.getValue().getName() + "] ");
                    if (current.getNext() != null)
                    {
                        System.out.print("-> ");
                    }
                    current = current.getNext();
                }
                System.out.println();
            }
        }
    }

    /**
     * Returns the total number of student records in the map.
     *
     * @return the size of the Hash Map
     */
    public int getSize()
    {
        return size;
    }
}