package test.java;

import main.java.tree.AVLTree;
import main.java.tree.BinarySearchTree;

public class AVLTreeDemo {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10);
        binarySearchTree.insert(20);
        binarySearchTree.insert(30);
        binarySearchTree.insert(40);
        binarySearchTree.insert(50);
        binarySearchTree.insert(60);
        binarySearchTree.insert(70);
        binarySearchTree.insert(80);

        System.out.println("Height of BS Tree : "+binarySearchTree.height());

        AVLTree avlTree = new AVLTree();
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(60);
        avlTree.insert(70);
        avlTree.insert(80);

        System.out.println("Height of AVL Tree : "+avlTree.height());
    }
}
