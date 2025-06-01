package main.java.tree;

/**
 * Implementation of a Binary Search Tree (BST)
 * Supports basic operations: insert, search, print (in-order),
 * height, size, min, max, and leaf node count.
 */
public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(int data) {
        root = new Node(data);
    }

    /**
     * Inserts a node into the BST.
     */
    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node currentNode, int data) {
        if (currentNode == null) {
            return new Node(data);
        }
        if (data < currentNode.data) {
            currentNode.left = insert(currentNode.left, data);
        } else if (data > currentNode.data) {
            currentNode.right = insert(currentNode.right, data);
        }
        return currentNode;
    }

    /**
     * Prints main.java.tree in in-order traversal.
     */
    public void print() {
        recursivePrint(root);
        System.out.println();
    }

    private void recursivePrint(Node currentNode) {
        if (currentNode == null) return;
        recursivePrint(currentNode.left);
        System.out.print(currentNode.data + " ");
        recursivePrint(currentNode.right);
    }

    /**
     * Returns height of the BST.
     * Empty main.java.tree height is -1.
     */
    public int height() {
        return height(root);
    }

    private int height(Node currentNode) {
        if (currentNode == null) return -1;
        return 1 + Math.max(height(currentNode.left), height(currentNode.right));
    }

    /**
     * Returns total number of nodes in the BST.
     */
    public int size() {
        return size(root);
    }

    private int size(Node currentNode) {
        if (currentNode == null) return 0;
        return 1 + size(currentNode.left) + size(currentNode.right);
    }

    /**
     * Returns number of leaf nodes (no left or right child).
     */
    public int noOfLeafNodes() {
        return noOfLeafNodes(root);
    }

    private int noOfLeafNodes(Node currentNode) {
        if (currentNode == null) return 0;
        if (currentNode.left == null && currentNode.right == null) return 1;
        return noOfLeafNodes(currentNode.left) + noOfLeafNodes(currentNode.right);
    }

    /**
     * Returns minimum value in the BST.
     * @throws IllegalStateException if main.java.tree is empty.
     */
    public int minimum() {
        if (root == null) throw new IllegalStateException("Tree is empty");
        return minimum(root);
    }

    private int minimum(Node currentNode) {
        return (currentNode.left == null) ? currentNode.data : minimum(currentNode.left);
    }

    /**
     * Returns maximum value in the BST.
     * @throws IllegalStateException if main.java.tree is empty.
     */
    public int maximum() {
        if (root == null) throw new IllegalStateException("Tree is empty");
        return maximum(root);
    }

    private int maximum(Node currentNode) {
        return (currentNode.right == null) ? currentNode.data : maximum(currentNode.right);
    }

    /**
     * Searches for a target value in the BST.
     */
    public boolean search(int target) {
        return search(root, target);
    }

    private boolean search(Node currentNode, int target) {
        if (currentNode == null) return false;
        if (currentNode.data == target) return true;
        return (target < currentNode.data)
                ? search(currentNode.left, target)
                : search(currentNode.right, target);
    }

    private class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }
}
