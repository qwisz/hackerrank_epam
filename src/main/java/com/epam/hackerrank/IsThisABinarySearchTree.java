package com.epam.hackerrank;

public class IsThisABinarySearchTree {

    class Node {
        int data;
        Node left;
        Node right;
    }

    public Node root = new Node();

    boolean checkBST(Node root) {
        if (root == null)
            return true;

        if (root.right != null && min(root.right) <= root.data)
            return false;

        if (root.left != null && max(root.left) >= root.data)
            return false;

        if (!checkBST(root.right) || !checkBST(root.left))
            return false;

        return true;
    }


    int max(Node node) {
        int max = node.data;
        Node curr = node;
        while (curr != null) {
            if (curr.data > max)
                max = curr.data;
            curr = curr.right;
        }
        return max;
    }

    int min(Node node) {
        int min = node.data;
        Node curr = node;
        while (curr != null) {
            if (curr.data < min)
                min = curr.data;
            curr = curr.left;
        }
        return min;
    }
}
