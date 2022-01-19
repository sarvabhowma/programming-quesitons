/*
largest independent set possible for the given tree

Input: tree is given by default

Output:
6
 */

package dynamic_programming;

import java.util.Scanner;

public class largest_independent_set {

    static class node {
        int value;
        int count = -1;
        node left = null;
        node right = null;

        node(int k) {
            value = k;
        }

    }

    static int lis(node root) {

        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            root.count = 1;
            return root.count;
        } else if (root.count != -1) {
            return root.count;
        }

        int first = 1;

        if (root.left != null) {
            first += lis(root.left.left);
            first += lis(root.left.right);
        }

        if (root.right != null) {
            first += lis(root.right.left);
            first += lis(root.right.right);
        }

        int sec = 0;

        sec += lis(root.left);
        sec += lis(root.right);

        root.count = Math.max(first, sec);

        return root.count;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        node root = new node(10);

        root.left = new node(20);
        root.right = new node(30);

        root.left.left = new node(40);
        root.left.right = new node(50);

        root.right.left = new node(60);
        root.right.right = new node(70);

        root.right.right.left = new node(80);
        root.right.right.right = new node(90);

        System.out.println(lis(root));

    }
}