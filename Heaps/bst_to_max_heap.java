/*
converting a bst to max_heap using reverse inorder traversal
inorder = left, root, right
reverse = right, root, left

input a tree is given by default in the program

Output :
max heap :
7 6 5 4 3 2 1

 */

package Heaps;

import java.util.Scanner;

public class bst_to_max_heap {
    public static int a[],i=0;
    static class node{

        int value;
        node right;
        node left;

        node(int k) {
            this.value = k;
            right = null;
            left = null;
        }
    }

    static void inorder(node head){
        if(head==null){
            return;
        }
        else{
            inorder(head.right);
            a[i++] = head.value;
            inorder(head.left);
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        node head = new node(4);
        head.left = new node(2);
        head.right = new node(6);
        head.left.left = new node(1);
        head.left.right = new node(3);
        head.right.left = new node(5);
        head.right.right = new node(7);

        a = new int[7];

        inorder(head);


        System.out.println("max heap : ");

        for(int j=0;j<7;j++){
            System.out.print(a[j]+" ");
        }
    }
}
