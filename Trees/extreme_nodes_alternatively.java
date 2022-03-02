/*
displaying the extreme nodes at each level alternatively

Input : tree is given by default

Output :
25 30 5 12 13

 */

package Trees;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class extreme_nodes_alternatively {

    static class node {
        int value;
        node left, right;

        node(int k) {
            value = k;
            left = null;
            right = null;
        }
    }

    static void extreme_nodes(node root) {

        int l = 0;
        Map<node, Integer> m = new HashMap<>();
        ArrayList<node> q = new ArrayList<>();

        q.add(root);
        m.put(q.get(0), l);
        System.out.print(root.value + " ");

        int x = -1;// for last element in odd level

        while (q.size() > 0) {

            l = (m.get(q.get(q.size() - 1)) + 1);
            if (q.get(0).left != null) {

                if (l % 2 == 0) {
                    System.out.print(q.get(q.size() - 1).value + " ");
                    System.out.print(q.get(0).left.value + " ");
                    l = l + 1;
                }

                q.add(q.get(0).left);
                m.put(q.get(0).left, m.get(q.get(0)) + 1);
            }

            if (q.get(0).right != null) {

                if (l % 2 == 0) {
                    System.out.print(q.get(q.size() - 1).value + " ");
                    System.out.print(q.get(0).right.value + " ");
                }

                q.add(q.get(0).right);
                m.put(q.get(0).right, m.get(q.get(0)) + 1);
            }

            if (q.size() == 1 && (m.get(q.get(q.size() - 1)) + 1) % 2 == 0) {
                x = q.get(0).value;
            }
            q.remove(0);

        }

        if (x != -1) {
            System.out.println(x);
        }

    }

    public static void main(String[] args) {

        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.left.right.left = new node(12);
        root.left.right.left.right = new node(13);

        extreme_nodes(root);
    }
}
