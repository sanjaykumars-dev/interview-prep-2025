package test.java;

import main.java.tree.BinarySearchTree;

public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);

        System.out.print("In-order Traversal: ");
        bst.print();

        System.out.println("Height: " + bst.height());              // 2
        System.out.println("Size: " + bst.size());                  // 5
        System.out.println("Leaf Nodes: " + bst.noOfLeafNodes());   // 2
        System.out.println("Minimum: " + bst.minimum());            // 3
        System.out.println("Maximum: " + bst.maximum());            // 15
        System.out.println("Search 7: " + bst.search(7));           // true
        System.out.println("Search 100: " + bst.search(100));       // false
    }
}

