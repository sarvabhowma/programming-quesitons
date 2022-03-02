/*
finding the level of a key in the given tree

Input : tree is given default

Output :
enter the key :
12
Recursive Method : 3
Iterative Method : 3

 */

package Trees;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class key_level {

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
    static int level_r(node root, int k, int l) {
        if (root == null) {
            return -1;
        }
        if (root.value == k) {
            return l;
        }
        int left = level_r(root.left, k, l + 1);
        if (left != -1) {
            return left;
        }
        int right = level_r(root.right, k, l + 1);
        if (right != -1) {
            return right;
        }
        return -1;
    }

    // Iterative Method
    static int level_i(node root, int k, int l) {
        Queue<node> q = new LinkedList<>();
        Map<node, Integer> m = new HashMap<>();
        l = -1;
        q.add(root);
        m.put(root, 0);

        while (q.size() != 0) {
            node temp = q.peek();
            if (temp.left != null) {
                q.add(temp.left);
                m.put(temp.left, m.get(temp) + 1);
            }
            if (temp.right != null) {
                q.add(temp.right);
                m.put(temp.right, m.get(temp) + 1);
            }
            if (temp.value == k) {
                l = m.get(temp);
                break;
            }
            q.remove();
        }

        return l;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.left.right.left = new node(12);

        System.out.println("enter the key : ");
        int k = sc.nextInt();

        System.out.println("Recursive Method : " + level_r(root, k, 0));

        System.out.println("Iterative Method : " + level_i(root, k, 0));

    }
}