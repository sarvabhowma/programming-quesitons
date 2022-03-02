/*
finding the nodes at distance k from the key

Input : tree is given by default
key = 10, level = 1

Output :
5 15 25

 */

package Trees;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class k_distance_from_key {

    static class node {
        int value;
        node left, right;

        node(int k) {
            this.value = k;
            left = null;
            right = null;
        }
    }

    static void nodes_at_level_k(node root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.print(root.value + " ");
        }
        nodes_at_level_k(root.left, k - 1);
        nodes_at_level_k(root.right, k - 1);
        return;
    }

    static int nodes_at_level_k_from_key(node root, int k, int l) {
        if (root == null) {
            return -1;
        }
        if (root.value == k) {
            nodes_at_level_k(root, l);
            return 0;
        }
        int left = nodes_at_level_k_from_key(root.left, k, l);
        if (left != -1) {
            if (left + 1 == l) {
                System.out.print(root.value + " ");
            } else {
                nodes_at_level_k(root.right, l - left - 2);
            }
            return l - 1;
        }
        int right = nodes_at_level_k_from_key(root.right, k, l);
        if (right != -1) {
            if (right + 1 == l) {
                System.out.print(root.value + " ");
            } else {
                nodes_at_level_k(root.left, l - right - 2);
            }
            return l - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.left.right.left = new node(12);

        int key = 5;
        int level = 2;

        nodes_at_level_k_from_key(root, key, level);

    }
}
