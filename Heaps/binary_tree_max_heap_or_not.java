/*
check whether the given binary tree is max_heap or not.

Input :
// tree is given by default
number of elements :
7

Output :
true

 */

package Heaps;

import java.util.Scanner;

public class binary_tree_max_heap_or_not {

    static class node{
        int value;
        node left, right;
        node(int k){
            this.value = k;
            left = null;
            right = null;
        }
    }

    static boolean check(node head){
        if(head.left==null && head.right==null){
            return true;
        }
        if(head.right == null){
            return head.value>head.left.value;
        }
        else{
            if(head.value>head.left.value && head.value>head.right.value){
                return check(head.left) && check(head.right);
            }
            else{
                return false;
            }
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("number of elements : ");
        int n = sc.nextInt();

        node head = new node(10);
        head.left = new node(7);
        head.right = new node(9);

        head.left.left = new node(2);
        head.left.right = new node(5);

        head.right.left = new node(3);
        head.right.right = new node(6);

        System.out.println(check(head));

    }
}
