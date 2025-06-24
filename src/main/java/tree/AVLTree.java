package main.java.tree;

public class AVLTree {

    private Node root;

    public void insert(int data){
        root = insert(data,root);
    }

    private Node insert(int data, Node current){
        if(current == null){
            return new Node(data);
        }

        if(data < current.data){
            current.left = insert(data,current.left);
        } else if(data > current.data) {
            current.right = insert(data, current.right);
        }

        return rotate(current);
    }

    private Node rotate(Node current){
        if(height(current.left) - height(current.right) > 1){
            if(height(current.left.left) - height(current.left.right) > 0){
                return rightRotate(current);
            }
            if(height(current.left.left) - height(current.left.right) < 0){
                current.left = leftRotate(current.left);
                return rightRotate(current);
            }
        }

        if(height(current.left) - height(current.right) < -1){
            if(height(current.right.left) - height(current.right.right) < 0){
                return leftRotate(current);
            }
            if(height(current.right.left) - height(current.right.right) > 0){
                current.right = rightRotate(current.left);
                return leftRotate(current);
            }
        }

        return current;
    }

    private Node rightRotate(Node parent){
        Node child = parent.left;
        Node tree = child.right;

        child.right = parent;
        parent.left = tree;

        return child;
    }

    private Node leftRotate(Node parent) {
        Node child = parent.right;
        Node tree = child.left;

        child.left = parent;
        parent.right = tree;

        return child;
    }


    public int height(){
        return height(root);
    }

    private int height(Node current){
        if(current == null){
            return -1;
        }
        return 1 + Math.max(height(current.left),height(current.right));
    }


    private class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }
}
