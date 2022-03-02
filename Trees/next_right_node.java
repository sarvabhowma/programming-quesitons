/*
next right node of a key in the given tree

Input: tree is given by default
key = 5

Output:
next right node : 15

 */
package Trees;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class next_right_node {

    static class node {
        int value;
        node left, right;

        node(int k) {
            value = k;
            left = null;
            right = null;
        }
    }

    static int nxt_right_node(node root, int k) {
        if (root == null) {
            return -1;
        }
        Queue<node> q = new LinkedList<>();
        Map<node, Integer> m = new HashMap<>();

        q.add(root);
        m.put(root, 0);
        int flag = -1;

        while (q.size() != 0) {

            if (q.peek().left != null) {
                q.add(q.peek().left);
                m.put(q.peek().left, m.get(q.peek()) + 1);
            }

            if (q.peek().right != null) {
                q.add(q.peek().right);
                m.put(q.peek().right, m.get(q.peek()) + 1);
            }

            if (flag != -1 && m.get(q.peek()) == flag) {
                return q.peek().value;
            }

            if (q.peek().value == k) {
                flag = m.get(q.peek());
            }

            q.remove();

        }
        return -1;
    }

    public static void main(String[] args) {

        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.left.right.left = new node(12);

        int key = 5;

        int val = nxt_right_node(root, key);

        if (val != -1) {
            System.out.println("next right node : " + val);
        } else {
            System.out.println("no right node");
        }

    }
}
