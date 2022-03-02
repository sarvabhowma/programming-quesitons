/*
checking whether removing an edge will divide the tree into two halves or not
two halves : two trees with same number of nodes

Input: tree is given by default

Output:
true

 */

package Trees;

public class two_halves {

    static class node {
        int value;
        node left, right;

        node(int k) {
            value = k;
            left = null;
            right = null;
        }
    }

    static int tree_size(node root) {
        if (root == null) {
            return 0;
        }
        int left = tree_size(root.left);
        int right = tree_size(root.right);

        return left + right + 1;
    }

    static int check(node root, int size, int[] flag) {
        if (root == null) {
            return 0;
        }

        int left = check(root.left, size, flag);
        int right = check(root.right, size, flag);

        if (2 * (left + right + 1) == size) {
            flag[0] = 1;
        }

        return left + right + 1;

    }

    public static void main(String[] args) {

        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.right.left = new node(28);
        root.right.right = new node(35);
        root.left.right.left = new node(12);

        int size = tree_size(root);
        int flag[] = new int[1];

        check(root, size, flag);

        if (flag[0] == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
