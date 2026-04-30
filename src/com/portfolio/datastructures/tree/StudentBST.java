package com.portfolio.datastructures.tree;

import com.portfolio.datastructures.model.Student;

/**
 * A Binary Search Tree to store and manage Student objects.
 * The student's ID number is used as the main sorting key to get
 * O(log N) search times.
 *
 * @author Abdullah Al Asmy
 * @version 1.0
 */
public class StudentBST
{
    private static final int EMPTY_SIZE = 0;

    private TreeNode root;
    private int size;

    /**
     * Constructs an empty Binary Search Tree.
     */
    public StudentBST()
    {
        this.root = null;
        this.size = EMPTY_SIZE;
    }

    /**
     * Inserts the specified student into the binary search tree.
     * The tree maintains its sorted structure based on the student's ID number.
     *
     * @param student the student to insert
     * @throws IllegalArgumentException if the student is null
     */
    public void insert(final Student student)
    {
        if (student == null)
        {
            throw new IllegalArgumentException("Cannot insert a null student into the tree.");
        }

        root = insertRecursive(root, student);
        size++;
    }

    /**
     * Handles the insertion logic by traversing the tree and comparing
     * student IDs.
     * If the new student's ID is smaller than the current node's ID,
     *      the traversal continues to the left branch.
     * If larger,
     *      it continues to the right branch.
     * Upon reaching a null position, a new node is created and linked.
     * A check is included to prevent duplicate IDs from being added to the structure.
     *
     * @param current the current node being evaluated
     * @param student the student to insert
     *
     * @return the new or existing node to update the tree structure
     */
    private TreeNode insertRecursive(final TreeNode current,
                                     final Student student)
    {
        if (current == null)
        {
            return new TreeNode(student);
        }

        if (student.getNumber() < current.getElement().getNumber())
        {
            current.setLeft(insertRecursive(current.getLeft(), student));
        }
        else if (student.getNumber() > current.getElement().getNumber())
        {
            current.setRight(insertRecursive(current.getRight(), student));
        }
        else
        {
            System.out.println("Student with ID #" + student.getNumber() + " already exists in the tree.");
            size--;
        }

        return current;
    }

    /**
     * Looks up a student by ID number.
     * This acts as a public wrapper that initiates the recursive search
     * starting from the root node.
     *
     * @param studentNumber the ID to search for
     *
     * @return the Student object, or null if not found
     */
    public Student search(final int studentNumber)
    {
        final TreeNode resultNode = searchRecursive(root, studentNumber);

        if (resultNode != null)
        {
            return resultNode.getElement();
        }

        System.out.println("Student #" + studentNumber + " not found in the tree.");
        return null;
    }

    /**
     * Recursively traverses the tree to locate a specific student ID.
     * The search space is halved at every step.
     * If the target ID is less than
     *      the current ID, only the left branch is evaluated.
     * If greater,
     *      only the right branch is evaluated.
     * The node is returned upon discovery, or null if a dead end is reached.
     *
     * @param current       the current node being evaluated
     * @param studentNumber the ID to search for
     * @return the node containing the student, null if not found
     */
    private TreeNode searchRecursive(final TreeNode current,
                                     final int studentNumber)
    {
        if (current == null || current.getElement().getNumber() == studentNumber)
        {
            return current;
        }

        if (current.getElement().getNumber() < studentNumber)
        {
            return searchRecursive(current.getRight(), studentNumber);
        }

        return searchRecursive(current.getLeft(), studentNumber);
    }

    /**
     * Prints out every student in the tree.
     * By using an in-order traversal, the output is automatically sorted
     * from lowest ID number to highest.
     */
    public void printInOrder()
    {
        if (root == null)
        {
            System.out.println("The tree is empty.");
            return;
        }

        System.out.println("--- BST In-Order Traversal (Sorted by ID) ---");
        inOrderRecursive(root);
    }

    /**
     * Performs an in-order traversal (left, root, right) starting from the given node.
     * Recursively visiting the left branch first, followed by the node itself,
     * and then the right branch ensures the output is printed in ascending numerical order.
     *
     * @param current the current node being evaluated
     */
    private void inOrderRecursive(final TreeNode current)
    {
        if (current != null)
        {
            inOrderRecursive(current.getLeft());
            System.out.println(current.getElement().toString());
            inOrderRecursive(current.getRight());
        }
    }

    /**
     * Returns the current number of students in the tree.
     *
     * @return the size of the tree
     */
    public int getSize()
    {
        return size;
    }
}