/*
checking a tree is subtree of another or not

Input : trees are given by default

Output :
true

 */
package Trees;

public class subtree_of_BT {

    static class node {
        int value;
        node left, right;

        node(int k) {
            this.value = k;
            left = null;
            right = null;
        }
    }

    static boolean identical(node root, node root1) {
        if (root == null && root1 == null) {
            return true;
        }
        if (root1 == null || root == null) {
            return false;
        }
        if (root.value != root1.value) {
            return false;
        }
        return identical(root.left, root1.left) && identical(root.right, root1.right);
    }

    static boolean subtree(node root, node root1) {
        if (root == null) {
            return false;
        }
        if (root1 == null) {
            return true;
        }
        if (root.value == root1.value) {
            if (identical(root, root1)) {
                return true;
            }
        }
        return subtree(root.left, root1) || subtree(root.right, root1);
    }

    public static void main(String[] args) {

        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.left.right.left = new node(12);

        node root1 = new node(15);
        root1.left = new node(12);

        System.out.println(subtree(root, root1));
    }
}
