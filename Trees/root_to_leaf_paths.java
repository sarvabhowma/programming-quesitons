/*
displaying all root to leaf paths in a binary tree

Input : tree is given by default

Output :
25 10 5
25 10 15 12
25 30
 */

package Trees;

import java.util.ArrayList;

public class root_to_leaf_paths {

    static class node {
        int value;
        node left, right;

        node(int k) {
            value = k;
            left = null;
            right = null;
        }
    }

    static void paths(node root, ArrayList<Integer> a) {
        if (root == null) {
            return;
        }

        a.add(root.value);

        if (root.left == null && root.right == null) {
            for (int i = 0; i < a.size(); i++) {
                System.out.print(a.get(i) + " ");
            }
            System.out.println();
        } else {
            paths(root.left, a);
            paths(root.right, a);
        }

        a.remove(a.size() - 1);
        return;
    }

    public static void main(String[] args) {

        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.left.right.left = new node(12);
        root.right.left = new node(27);
        root.right.right = new node(35);

        ArrayList<Integer> a = new ArrayList<>();

        paths(root, a);
    }
}
