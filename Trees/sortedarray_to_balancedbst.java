/*
constructing balanced binary search tree from sorted array

Input :
6 // array size
1 2 3 4 56 123

Output :
1 2 3 4 56 123

 */
package Trees;

import java.util.Scanner;

public class sortedarray_to_balancedbst {

    static class node {
        int value;
        node left, right;

        node(int k) {
            this.value = k;
            left = null;
            right = null;
        }
    }

    static void display(node root) {
        if (root == null) {
            return;
        }
        display(root.left);
        System.out.print(root.value+" ");
        display(root.right);
    }

    static node sa_to_bbst(int a[], int first, int last) {
        if (first > last) {
            return null;
        }
        int mid = (first + last) / 2;

        node root = new node(a[mid]);

        root.left = sa_to_bbst(a, first, mid - 1);
        root.right = sa_to_bbst(a, mid + 1, last);

        return root;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        node root = sa_to_bbst(a, 0, n - 1);

        display(root);
    }
}

