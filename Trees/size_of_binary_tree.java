/*
calculating the size of the binary tree

Input :
it is given by default

Output :
Recursive Method : 6
Iterative Method : 6

 */

package Trees;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class size_of_binary_tree {

    static class node {
        int value;
        node left, right;

        node(int k) {
            this.value = k;
            left = null;
            right = null;
        }
    }

    // recursive method
    static int size_r(node head) {
        return (head != null) ? (1 + size_r(head.left) + size_r(head.right)) : 0;
    }

    // iterative method
    static int size_i(node head){
        int k = 0;
        Queue<node> q = new LinkedList<>();
        if(head!=null) {
            q.add(head);
            k+=1;
        }
        while(q.size()!=0){
            node temp = q.peek();
            if(temp.left!=null){
                q.add(q.peek().left);
                k+=1;
            }
            if(temp.right!=null){
                q.add(q.peek().right);
                k+=1;
            }
            q.remove();
        }

        return k;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        node head = new node(10);
        head.left = new node(20);
        head.right = new node(30);

        head.left.left = new node(40);
        head.left.right = new node(50);

        head.right.left = new node(60);
//        head.right.right = new node(70);

        System.out.println("Recursive Method : "+size_r(head));

        System.out.println("Iterative Method : "+size_i(head));

    }
}
