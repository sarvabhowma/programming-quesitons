/*
finding the lowest common ancestor in a binary tree

Input : is given by default
ancestor for 5 and 30

Output :
25

 */
package Trees;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class lowest_common_ancestor_BT {

    static class node {
        int value;
        node left, right;

        node(int k) {
            this.value = k;
            left = null;
            right = null;
        }
    }

    static node LCR_r(node root, int p, int q) {
        if (root == null) {
            return root;
        } else if (root.value == p || root.value == q) {
            return root;
        }
        node left = LCR_r(root.left, p, q);
        node right = LCR_r(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return root.left;
        } else
            return root.right;
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.left.right.left = new node(12);

        System.out.println((LCR_r(root, 30, 5)).value);

    }
}
