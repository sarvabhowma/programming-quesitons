/*
left view of a binary tree

Input : tree is given by default

Output :
25 10 5 12

 */

package Trees;

public class left_view_of_BT {

    static class node {
        int value;
        node left, right;

        node(int k) {
            this.value = k;
            left = null;
            right = null;
        }
    }

    static void left_view(node root, int[] max, int l) {
        if (root == null) {
            return;
        }
        if (max[0] < l) {
            max[0] = l;
            System.out.print(root.value + " ");
        }
        left_view(root.left, max, l + 1);
        left_view(root.right, max, l + 1);
    }

    public static void main(String[] args) {

        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.left.right.left = new node(12);

        int max[] = new int[1];
        max[0] = -1;

        left_view(root, max, 0);
    }
}
