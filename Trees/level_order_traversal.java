/*
displaying level order traversal of the tree

Input : input is given by default

Output :
10 20 30 40 50 60 70

 */
package Trees;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class level_order_traversal {

    static class node{
        int value;
        node left, right;
        node(int k){
            this.value = k;
            left = null;
            right = null;
        }
    }

    static void display(Queue<node> q){
        if(q.size()==0)
            return;
        else{
            System.out.print(q.peek().value+" ");
            if(q.peek().left!=null){
                q.add(q.peek().left);
            }
            if(q.peek().right!=null){
                q.add(q.peek().right);
            }
            q.remove();
            display(q);
        }

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        node root = new node(10);

        root.left = new node(20);
        root.right = new node(30);

        root.left.left = new node(40);
        root.left.right = new node(50);

        root.right.left = new node(60);
        root.right.right = new node(70);

        Queue<node> q = new LinkedList<>();
        q.add(root);
        display(q);

    }
}
