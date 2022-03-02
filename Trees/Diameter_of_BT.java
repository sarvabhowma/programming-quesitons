/*
finding the length of the diameter(largest distance between any two nodes in a binary
tree)

Input : is given by default

Output : displaying the diameters at every node
5, 0
12, 0
15, 1
10, 3
30, 0
25, 4
4

 */
package Trees;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Diameter_of_BT {

    static class length {
        int h, d;

        length(int h, int d) {
            this.h = h;
            this.d = d;
        }
    }

    static class node {
        int value;
        node left, right;

        node(int k) {
            this.value = k;
        }
    }

    static length diameter_r(node root) {

        length l = new length(0, 0);
        if (root == null) {
            return l;
        }

        length left = diameter_r(root.left);
        length right = diameter_r(root.right);

        l.h = Math.max(left.h, right.h) + 1;
        l.d = Math.max(Math.max(left.d, right.d), left.h + right.h);

        System.out.println(root.value + ", " + l.d);
        return l;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.left.right.left = new node(12);

        length l = diameter_r(root);

        System.out.println(l.d);
    }
}




