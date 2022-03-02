/*
converting a binary search tree to doubly linked list with inplace node values,
means without using any other storages.

Input : is given by default

Output :
5 10 12 15 25 30

 */

package Trees;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class convert_BST_to_DLL {

    static class node {
        int value;
        node left, right;

        node(int k) {
            this.value = k;
            left = null;
            right = null;
        }
    }

    static node BST_to_DLL(node root) {
        if (root == null) {
            return root;
        }
        node left = BST_to_DLL(root.left);
        node right = BST_to_DLL(root.right);

        node temp = null;

        if (left == null && right == null) {
            root.right = root;
            return root;
        }

        if (left != null) {
            temp = left.right;
            left.right = root;
            root.right = temp;
            temp = root;
        }
        if (right != null) {
            temp = root.right;
            root.right = right.right;
            right.right = temp;
            temp = right;
        }

        return temp;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.left.right.left = new node(12);

        node end = BST_to_DLL(root);
        node front = end.right;
        end.right = null;

        while (front != null) {
            System.out.print(front.value + " ");
            front = front.right;
        }
    }
}
