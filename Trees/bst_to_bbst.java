/*
converting binary search tree to balanced binary search tree

Input : tree is given by default

Output :
level before : 4
level after : 2

 */
package Trees;

import java.util.ArrayList;

public class bst_to_bbst {

    static class node {
        int value;
        node left, right;

        node(int k) {
            value = k;
            left = null;
            right = null;
        }
    }

    static int level(node root, int l) {
        if (root == null) {
            return l - 1;
        }
        int left = level(root.left, l + 1);
        int right = level(root.right, l + 1);
        return Math.max(left, right);
    }

    static void bst_to_array(node root, ArrayList<node> a) {
        if (root == null) {
            return;
        }
        bst_to_array(root.left, a);
        a.add(root);
        bst_to_array(root.right, a);
    }

    static node array_to_bbst(ArrayList<node> a, int first, int last) {
        if (first > last) {
            return null;
        }
        int mid = (first + last) / 2;
        node temp = a.get(mid);
        temp.left = array_to_bbst(a, first, mid - 1);
        temp.right = array_to_bbst(a, mid + 1, last);
        return temp;
    }

    public static void main(String[] args) {
        node root = new node(10);
        root.right = new node(20);
        root.right.right = new node(30);
        root.right.right.right = new node(40);
        root.right.right.right.right = new node(50);

        ArrayList<node> a = new ArrayList<>();

        System.out.println("level before : " + level(root, 0));
        bst_to_array(root, a);

        node root1 = array_to_bbst(a, 0, a.size() - 1);
        System.out.println("level after : " + level(root1, 0));
    }
}


