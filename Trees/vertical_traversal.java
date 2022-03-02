/*
traversing the tree vertically

Input : tree is given by default

Output :
nodes at level -2 :
5
nodes at level -1 :
10 12
nodes at level 0 :
25 15
nodes at level 1 :
30

 */

package Trees;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class vertical_traversal {

    static class node {
        int value;
        node left, right;

        node(int k) {
            this.value = k;
        }
    }

    static void traversal(node root, Map<Integer, node> m, int[] a, int h) {
        if (root == null) {
            return;
        }
        if (m.containsKey(h)) {
            node temp = m.get(h);
            while(temp.right!=null){
                temp = temp.right;
            }
            temp.right = new node(root.value);
        } else {
            m.put(h, new node(root.value));
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



        Map<Integer, node> m = new HashMap<>();
        int a[] = new int[2];// min is a[0] and max is a[1]

        traversal(root, m, a, 0);

        for (int i = a[0]; i <= a[1]; i++) {
            node temp = m.get(i);
            System.out.print("nodes at level " + i + " : ");
            while (temp != null) {
                System.out.print(temp.value + " ");
                temp = temp.right;
            }
            System.out.println();
        }
    }
}
