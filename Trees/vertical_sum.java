/*
traversing the tree vertically and adding them level wise

Input : tree is given by default

Output :
sum at level -2 : 5
sum at level -1 : 22
sum at level 0 : 40
sum at level 1 : 30

 */
package Trees;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class vertical_sum {

    static class node {
        int value;
        node left, right;

        node(int k) {
            this.value = k;
        }
    }

    static void traversal(node root, Map<Integer, Integer> m, int[] a, int h) {
        if (root == null) {
            return;
        }
        if (m.containsKey(h)) {
            m.put(h, m.get(h) + root.value);
        } else {
            m.put(h, root.value);
        }
        if (a[0] > h) {
            a[0] = h;
        }
        if (a[1] < h) {
            a[1] = h;
        }
        traversal(root.left, m, a, h - 1);
        traversal(root.right, m, a, h + 1);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.left.right.left = new node(12);

        Map<Integer, Integer> m = new HashMap<>();
        int a[] = new int[2];// min is a[0] and max is a[1]

        traversal(root, m, a, 0);

        for (int i = a[0]; i <= a[1]; i++) {

            System.out.println("sum at level " + i + " : " + m.get(i));
        }
    }
}
