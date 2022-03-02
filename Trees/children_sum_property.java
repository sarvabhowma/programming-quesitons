/*
root node value should be equal to sum of left and right child values,
if the root value is less than the sum value then we can increment it,
if the root value is greater than the sum value then we will increment
the value of left child or right child

Input : tree is given by default

Output : level order traversal
before :
55 10 25 9 4 3 11 4
after :
55 30 25 26 4 14 11 14

 */

package Trees;

import java.util.Queue;
import java.util.LinkedList;

public class children_sum_property {

    static class node {
        int value;
        node left, right;

        node(int k) {
            value = k;
            left = null;
            right = null;
        }
    }

    static void display(node root) {
        Queue<node> q = new LinkedList<>();
        q.add(root);

        while (q.size() != 0) {
            if (q.peek().left != null) {
                q.add(q.peek().left);
            }
            if (q.peek().right != null) {
                q.add(q.peek().right);
            }
            System.out.print(q.peek().value + " ");
            q.remove();
        }
        System.out.println();
    }

    static void increment(node root, int diff) {
        if (root == null) {
            return;
        }
        root.value += diff;
        if (root.left != null) {
            increment(root.left, diff);
        } else if (root.right != null) {
            increment(root.right, diff);
        }

    }

    static void sum_property(node root) {

        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        sum_property(root.left);
        sum_property(root.right);

        int sum = 0;

        if(root.left!=null){
            sum+=root.left.value;
        }
        if(root.right!=null){
            sum+=root.right.value;
        }

        if (root.value > sum) {

            if (root.left != null) {
                increment(root.left, root.value - sum);
            } else {
                increment(root.right, root.value - sum);
            }
        } else {
            root.value = sum;
        }
    }

    public static void main(String[] args) {

        node root = new node(55);
        root.left = new node(10);
        root.right = new node(25);
        root.left.left = new node(9);
        root.left.right = new node(4);
        root.right.left = new node(3);
        root.right.left.right = new node(4);
        root.right.right = new node(11);

        System.out.println("before : ");
        display(root);

        sum_property(root);

        System.out.println("after : ");
        display(root);
    }
}
