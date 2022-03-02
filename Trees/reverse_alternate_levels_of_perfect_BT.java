/*
reverse alternate levels of perfect binary tree

Input: tree is given by default

Output:
before : 25 10 30 5 15 28 35
after : 25 30 10 5 15 28 35

 */
package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class reverse_alternate_levels_of_perfect_BT {

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

    static void reverse_al(node r1, node r2, int level){
        if(r1==null || r2==null ){
            return ;
        }
        if(level%2==0){
            int temp = r1.value;
            r1.value = r2.value;
            r2.value = temp;
        }

        reverse_al(r1.left,r2.right,level+1);
        reverse_al(r1.right,r2.left,level+1);
    }

    public static void main(String[] args) {

        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.right.left = new node(28);
        root.right.right = new node(35);

        System.out.print("before : ");
        display(root);

        reverse_al(root.left, root.right, 0);

        System.out.print("after : ");
        display(root);

    }
}
