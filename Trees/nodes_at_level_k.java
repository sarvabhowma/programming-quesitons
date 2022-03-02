/*
displaying the nodes at level k in the binary tree

Input : tree is given by default

Output :
enter the k level :
2
Recursive Method : 5, 15,
Iterative Method : 5, 15,

 */

package Trees;

import java.util.*;

public class nodes_at_level_k {

    static class node {
        int value;
        node left, right;

        node(int k) {
            this.value = k;
            left = null;
            right = null;
        }
    }

    // Recursive Method
    static void level_k_nodes_r(node root, int k, int l) {
        if (root == null) {
            return;
        }
        if (l == k) {
            System.out.print(root.value + ", ");
        }
        level_k_nodes_r(root.left, k, l + 1);
        level_k_nodes_r(root.right, k, l + 1);
        return;
    }

    // Iterative Method
    static void level_k_nodes_i(node root, int k, int l) {
        Queue<node> q = new LinkedList<>();
        Map<node, Integer> m = new HashMap<>();
        q.add(root);
        m.put(root, 0);

        while (q.size() != 0) {
            if (m.get(q.peek()) > k) {
                break;
            }
            if (m.get(q.peek()) == k) {
                System.out.print(q.peek().value + ", ");
            }
            if (q.peek().left != null) {
                q.add(q.peek().left);
                m.put(q.peek().left, m.get(q.peek()) + 1);
            }
            if (q.peek().right != null) {
                q.add(q.peek().right);
                m.put(q.peek().right, m.get(q.peek()) + 1);
            }
            q.remove();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.left.right.left = new node(12);

        System.out.println("enter the k level : ");
        int k = sc.nextInt();

        System.out.print("Recursive Method : ");
        level_k_nodes_r(root, k, 0);

        System.out.print("\nIterative Method : ");
        level_k_nodes_i(root, k, 0);
    }
}
