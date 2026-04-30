package com.portfolio.datastructures.list;

import com.portfolio.datastructures.model.Student;

/**
 * Represents a single node in a singly linked list.
 *
 * @author Abdullah Al Asmy
 * @version 1.0
 */
public final class Node
{
    private Student element;
    private Node next;

    /**
     * Constructs a Node with a specified Student element.
     *
     * @param element the student data
     * @throws IllegalArgumentException if the element is null
     */
    public Node(final Student element)
    {
        validateElement(element);
        this.element = element;
        this.next = null;
    }

    /**
     * Validates that the student element is not null.
     *
     * @param inputElement the student to validate
     */
    private void validateElement(final Student inputElement)
    {
        if (inputElement == null)
        {
            throw new IllegalArgumentException("Node element cannot be null.");
        }
    }

    /**
     * Returns the student element in this node.
     *
     * @return the student element
     */
    public Student getElement()
    {
        return element;
    }

    /**
     * Sets the student element for this node.
     *
     * @param element the student data to set
     * @throws IllegalArgumentException if the element is null
     */
    public void setElement(final Student element)
    {
        validateElement(element);
        this.element = element;
    }

    /**
     * Returns the next node in the sequence.
     *
     * @return the next node
     */
    public Node getNext()
    {
        return next;
    }

    /**
     * Sets the next node in the sequence.
     *
     * @param next the next node
     */
    public void setNext(final Node next)
    {
        this.next = next;
    }
}