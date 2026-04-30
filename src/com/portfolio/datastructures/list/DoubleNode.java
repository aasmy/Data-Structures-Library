package com.portfolio.datastructures.list;

import com.portfolio.datastructures.model.Student;

/**
 * Represents a node in a doubly linked list, containing references
 * to both the next and previous nodes.
 *
 * @author Abdullah Al Asmy
 * @version 1.0
 */
public final class DoubleNode
{
    private Student element;
    private DoubleNode next;
    private DoubleNode prev;

    /**
     * Constructs a DoubleNode with a specified Student element.
     *
     * @param element the student data
     * @throws IllegalArgumentException if the element is null
     */
    public DoubleNode(final Student element)
    {
        validateElement(element);
        this.element = element;
        this.next = null;
        this.prev = null;
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
            throw new IllegalArgumentException("DoubleNode element cannot be null.");
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
    public DoubleNode getNext()
    {
        return next;
    }

    /**
     * Sets the next node in the sequence.
     *
     * @param next the next node
     */
    public void setNext(final DoubleNode next)
    {
        this.next = next;
    }

    /**
     * Returns the previous node in the sequence.
     *
     * @return the previous node
     */
    public DoubleNode getPrev()
    {
        return prev;
    }

    /**
     * Sets the previous node in the sequence.
     *
     * @param prev the previous node
     */
    public void setPrev(final DoubleNode prev)
    {
        this.prev = prev;
    }
}