/*
multiplying the sum of value at each level in a binary tree

Input : tree is given by default

Output :
240000

 */

package Trees;

import java.util.Map;
import java.util.HashMap;

public class multi_sum_of_levels {

    static class node {
        int value;
        node left, right;

        node(int k) {
            value = k;
            left = null;
            right = null;
        }
    }

    static int sum_of_levels(node root, Map<Integer, Integer> m, int l) {
        if (root == null) {
            return l - 1;
        }
        if (m.containsKey(l)) {
            m.replace(l, m.get(l) + root.value);
        } else {
            m.put(l, root.value);
        }

        int left = sum_of_levels(root.left, m, l + 1);
        int right = sum_of_levels(root.right, m, l + 1);

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.left.right.left = new node(12);

        Map<Integer, Integer> m = new HashMap<>();

        int levels = sum_of_levels(root, m, 0);

        int product = 1;

        for (int i = 0; i <= levels; i++) {
            product *= m.get(i);
        }

        System.out.println(product);
    }
}
