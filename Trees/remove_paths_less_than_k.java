/*
remove the paths in a binary tree where the distance of root
and the leaf in that path is less than k.

Input : tree is given by default
k = 2

Output :
Before Removal : 25 10 30 5 15 12
After Removal : 25 10 5 15 12

 */
package Trees;

import java.util.Queue;
import java.util.LinkedList;

public class remove_paths_less_than_k {

    static class node {
        int value;
        node left, right;

        node(int k) {
            this.value = k;
            left = null;
            right = null;
        }
    }

    static int rpaths_lessthan_k(node root, int k, int l) {
        if (root == null) {
            return l - 1;
        }
        int left = rpaths_lessthan_k(root.left, k, l + 1);
        int right = rpaths_lessthan_k(root.right, k, l + 1);
        if (left < k) {
            root.left = null;
        }
        if (right < k) {
            root.right = null;
        }
        return Math.max(left, right);
    }

    static void display(node root) {
        Queue<node> q = new LinkedList<>();
        q.add(root);
        while (q.size() != 0) {

            System.out.print(q.peek().value+" ");

            if (q.peek().left != null) {
                q.add(q.peek().left);
            }
            if (q.peek().right != null) {
                q.add(q.peek().right);
            }
            q.remove();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.left.right.left = new node(12);

        int k = 2;

        //before removal
        System.out.print("\nBefore Removal : ");
        display(root);

        rpaths_lessthan_k(root, k, 0);

        //after removal
        System.out.print("\nAfter Removal : ");
        display(root);
    }
}
