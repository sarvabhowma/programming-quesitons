/*
largest sum independent set in binary tree

Input: tree is given by default

Output:
43

 */

package dynamic_programming;

import java.util.Scanner;

public class sum_independent_set{

    static class node{
        int value;
        int max=-1;
        node left,right;

        node(int x){
            value = x;
            left = null;
            right = null;
        }
    }

    static int sum_independent_set(node root){

        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            root.max = root.value;
            return root.max;
        }
        if(root.max!=-1){
            return root.max;
        }
        int first = root.value;

        if(root.left!=null){
            first += sum_independent_set(root.left.left);
            first += sum_independent_set(root.left.right);
        }

        if(root.right!=null){
            first +=sum_independent_set(root.right.left);
            first +=sum_independent_set(root.right.right);
        }

        int sec = sum_independent_set(root.left);
        sec += sum_independent_set(root.right);

        root.max = Math.max(first,sec);

        return root.max;

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        node root = new node(5);
        root.left = new node(10);
        root.right = new node(6);
        root.left.left = new node(4);
        root.left.right = new node(3);
        root.left.left.left = new node(11);
        root.left.right.left = new node(6);
        root.right.left = new node(15);
        root.right.right = new node(1);

        System.out.println(sum_independent_set(root));
    }
}

