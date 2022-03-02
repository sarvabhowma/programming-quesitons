/*
converting the given tree to sum tree
sum tree: root value = sum of left tree and right tree

Input: tree is given by default

Output:
before : 25 10 30 5 15 12
after : 72 32 0 0 12 0

 */

package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class convert_to_sum_tree {

    static class node{
        int value;
        node left, right;
        node(int k){
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

    static int sum_tree(node root){
        if(root==null){
            return 0;
        }
        int x = root.value;

        int left = sum_tree(root.left);
        int right = sum_tree(root.right);

        root.value = left+right;

        return x+left+right;
    }
    public static void main(String[] args){

        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.left.right.left = new node(12);

        System.out.print("before : ");
        display(root);

        sum_tree(root);

        System.out.print("after : ");
        display(root);

    }
}
