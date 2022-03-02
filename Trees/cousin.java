/*
check whether the given two nodes are cousins are not
cousin(if both nodes have same parent).

Input : tree is given by default
p=5
q=15

Output :
true

 */

package Trees;

public class cousin {

    static class node {
        int value;
        node left, right;

        node(int k) {
            this.value = k;
            left = null;
            right = null;
        }
    }

    static int level(node root, int p, int l) {
        if (root == null) {
            return -1;
        }
        if (root.value == p) {
            return l;
        }
        int left = level(root.left, p, l + 1);
        int right = level(root.right, p, l + 1);

        if (left != -1) {
            return left;
        }
        if (right != -1) {
            return right;
        }
        return -1;
    }

    static boolean cousins(node root, int p, int q) {
        if (root == null) {
            return false;
        }
        if (root.left != null && root.right != null)
            if ((root.left.value == p || root.right.value == q) || (root.left.value == q || root.right.value == p)) {
                return true;
            }
        return cousins(root.left, p, q) || cousins(root.right, p, q);
    }

    public static void main(String[] args) {

        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);

        int p = 5;
        int q = 15;

        if (level(root, p, 0) == level(root, q, 0)) {
            System.out.println(cousins(root, p, q));
        } else {
            System.out.println("not cousins");
        }
    }
}

