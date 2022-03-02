/*
nodes which are at distance k from leaf

Input : tree is given by default

Output :
25 10

 */

package Trees;

import java.util.ArrayList;

public class distance_k_from_leaf {

    static class node {
        int value;
        node left, right;

        node(int k) {
            value = k;
            left = null;
            right = null;
        }
    }

    static void nodes_at_dis_k(node root, ArrayList<Integer> a, ArrayList<Integer> b, int k) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (!a.contains(root.value) && b.size() >= k) {
                a.add(b.get(b.size() - k));
            }
            return;
        }
        b.add(root.value);

        nodes_at_dis_k(root.left, a, b, k);
        nodes_at_dis_k(root.right, a, b, k);

        b.remove(b.size() - 1);
        return;
    }

    public static void main(String[] args) {

        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.left.right.left = new node(12);

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        int k = 2;

        nodes_at_dis_k(root, a, b, k);

        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + " ");
        }
    }
}
