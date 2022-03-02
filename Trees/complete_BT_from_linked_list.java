/*
complete binary tree from linked list

Input: list is given by default

Output:
level order traversal :
1 2 3 4 5 6

 */
package Trees;

import java.util.Queue;
import java.util.LinkedList;

public class complete_BT_from_linked_list {

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
            System.out.print(q.peek().value+" ");
            q.remove();
        }
    }

    static node conversion(LinkedList<Integer> l){

        Queue<node> q = new LinkedList<>();

        node root = new node(l.peek());
        l.remove();

        q.add(root);

        while(q.size()!=0){

            if(l.size()!=0){
                q.peek().left = new node(l.peek());
                q.add(q.peek().left);
                l.remove();
            }
            if(l.size()!=0){
                q.peek().right = new node(l.peek());
                q.add(q.peek().right);
                l.remove();
            }

            q.remove();
        }
        return root;

    }

    public static void main(String[] args){

        LinkedList<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);

        node root = conversion(l);
        System.out.println("level order traversal : ");
        display(root);

    }
}


