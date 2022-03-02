/*
level order traversal in spiral form

Input : tree is given by default

Output : 25 10 30 15 5 12

 */

package Trees;

import java.util.HashMap;
import java.util.Map;

public class level_order_in_spiral_form {

    static class node {
        int value;
        node left, right;

        node(int k) {
            value = k;
            left = null;
            right = null;
        }
    }

    static int spiral_form(node root, Map<Integer, node> m, int l) {
        if (root == null) {
            return l - 1;
        }
        if (l % 2 == 0) {
            if (m.containsKey(l)) {
                node temp = new node(root.value);
                temp.right = m.get(l);
                m.replace(l, temp);
            } else {
                m.put(l, new node(root.value));
            }
        } else {
            if (m.containsKey(l)) {
                node temp = m.get(l);
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = new node(root.value);
            } else {
                m.put(l, new node(root.value));
            }
        }
        
        int left = spiral_form(root.left, m, l + 1);
        int right = spiral_form(root.right, m, l + 1);

        return Math.max(left, right);
    }

    public static void main(String[] args) {

        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.left.right.left = new node(12);

        Map<Integer, node> m = new HashMap<>();

        int max_level = spiral_form(root, m, 0);

        for (int i = 0; i <= max_level; i++) {
            node temp = m.get(i);
            while (temp != null) {
                System.out.print(temp.value + " ");
                temp = temp.right;
            }
        }

    }
}

