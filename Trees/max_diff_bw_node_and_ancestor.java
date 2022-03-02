/*
maximum difference between a node and its ancestor in
a tree

Input : tree is given by default

Output :
20

 */
package Trees;

public class max_diff_bw_node_and_ancestor {

    static class node {
        int value;
        node left, right;

        node(int k) {
            value = k;
            left = null;
            right = null;
        }
    }

    static int max_diff(node root, int[] m) {
        if (root == null) {
            return 99999;
        }
        if (root.left == null && root.right == null) {
            return root.value;
        }
        int left = max_diff(root.left, m);
        int right = max_diff(root.right, m);

        int min = Math.min(left, right);
        m[0] = Math.max(m[0], root.value - min);

        return min;
    }

    public static void main(String[] args) {
        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.left.right.left = new node(12);

        int m[] = new int[1]; // maximum difference
        int min = 9999;

        max_diff(root, m);

        System.out.println(m[0]);
    }
}
