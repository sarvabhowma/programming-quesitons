/*
creating binary tree from inorder and postorder

Input :
enter the size of the array :
6
enter the inorder :
5 10 12 15 25 30
enter the post order :
5 12 15 10 30 25

Output : after bt is created
Inorder after tree :
5 10 12 15 25 30

 */
package Trees;

import java.util.Scanner;

public class bt_from_io_po {

    static class node {
        int value;
        node left, right;

        node(int k) {
            value = k;
            left = null;
            right = null;
        }
    }

    static void in_order(node root) {
        if (root == null) {
            return;
        }
        in_order(root.left);
        System.out.print(root.value + " ");
        in_order(root.right);
        return;
    }

    static node bt(int[] a, int[] b, int in_s, int in_l, int pst_index) {
        if (in_s == in_l) {
            return new node(a[in_s]);
        }
        if(in_s>in_l){
            return null;
        }
        int x = 0;
        for (int i = in_s; i <= in_l; i++) {
            if (a[i] == b[pst_index]) {
                x = i;
                break;
            }
        }
        node temp = new node(a[x]);

        int left_count = x - in_s;// number of elements in left tree
        int right_count = in_l - x;// number of elements in right tree

        temp.left = bt(a, b, in_s, x - 1, pst_index - right_count - 1);
        temp.right = bt(a, b, x + 1, in_l, pst_index - 1);

        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        System.out.println("enter the inorder : ");
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("enter the post order : ");
        int b[] = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        node root = bt(a, b, 0, n - 1, n - 1);

        System.out.println("Inorder after tree : ");
        in_order(root);
    }
}
