package com.portfolio.datastructures.tree;

import com.portfolio.datastructures.model.Student;

/**
 * Represents a node in a Binary Search Tree (BST).
 *
 * @author Abdullah Al Asmy
 * @version 1.0
 */
public final class TreeNode
{
    private Student element;
    private TreeNode left;
    private TreeNode right;

    /**
     * Constructs a TreeNode with a Student element.
     *
     * @param element the student data
     * @throws IllegalArgumentException if the element is null
     */
    public TreeNode(final Student element)
    {
        validateElement(element);
        this.element = element;
        this.left = null;
        this.right = null;
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
            throw new IllegalArgumentException("TreeNode element cannot be null.");
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
     * Returns the left child node.
     *
     * @return the left child node
     */
    public TreeNode getLeft()
    {
        return left;
    }

    /**
     * Sets the left child node.
     *
     * @param left the left child node
     */
    public void setLeft(final TreeNode left)
    {
        this.left = left;
    }

    /**
     * Returns the right child node.
     *
     * @return the right child node
     */
    public TreeNode getRight()
    {
        return right;
    }

    /**
     * Sets the right child node.
     *
     * @param right the right child node
     */
    public void setRight(final TreeNode right)
    {
        this.right = right;
    }
}