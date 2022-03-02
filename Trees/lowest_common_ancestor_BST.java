/*
Finding the lowest common ancestor of a given node

Input : given by default
selected node are 5 and 12

Output :
Recursive Method : 10
Iterative Method : 10

 */
package Trees;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class lowest_common_ancestor_BST {

    static class node{
        int value;
        node left, right;
        node(int k){
            this.value = k;
            left = null;
            right = null;
        }
    }

    // Recursive Method
    static int LCA_r(node root, int x, int y){

        if(root==null){
            return -1;
        }
        else if(root.value>x && root.value>y){
            return LCA_r(root.left,x,y);
        }
        else if(root.value<x && root.value<y){
            return LCA_r(root.right,x,y);
        }

        return root.value;
    }

    // Iterative Method
    static int LCA_i(node root, int x, int y){

        while(root!=null){
            if(root.value>x && root.value>y){
                root = root.left;
            }
            else if(root.value<x && root.value<y){
                root = root.right;
            }
            else
                return root.value;
        }

        return -1;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);

        root.left.left = new node(5);
        root.left.right = new node(15);

        root.left.right.left = new node(12);

        System.out.println("Recursive Method : "+LCA_r(root,5,12));

        System.out.println("Iterative Method : "+LCA_i(root,5,12));
    }
}
