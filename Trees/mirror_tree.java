/*
finding the mirror of the given tree

Input : given by default

Output :
tree before mirroring : 10 20 30 40 50 60 70
tree after mirroring using recursion : 10 30 20 70 60 50 40
mirroring again using iterative : 10 20 30 40 50 60 70

 */

package Trees;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class mirror_tree {

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

    //Recursive Method
    static void mirror_r(Queue<node> q){
        if(q.size()==0)
            return;
        else{
            if(q.peek().left!=null)
                q.add(q.peek().left);
            if(q.peek().right!=null)
                q.add(q.peek().right);

            node temp = q.peek().left;

            q.peek().left = q.peek().right;
            q.peek().right = temp;
            q.remove();
            mirror_r(q);
        }
    }

    // Iterative Method
    static void mirror_i(node root){
        Queue<node> q = new LinkedList<>();
        q.add(root);

        while(q.size()!=0){
            if(q.peek().left!=null)
                q.add(q.peek().left);
            if(q.peek().right!=null)
                q.add(q.peek().right);

            node temp = q.peek().left;

            q.peek().left = q.peek().right;
            q.peek().right = temp;
            q.remove();
        }
    }

    static node mirror_test(node root){
        if(root == null){
            return null;
        }
        node temp = root.left;
        root.left = mirror_test(root.right);
        root.right = mirror_test(temp);

        return root;
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

        System.out.print("tree before mirroring : ");
        q.add(root);
        display(q);

        q.add(root);
        mirror_r(q);

        System.out.print("\ntree after mirroring using recursion : ");
        q.add(root);
        display(q);

        mirror_i(root);

        System.out.print("\nmirroring again using iterative : ");
        q.add(root);
        display(q);

        System.out.print("\nmirroring test code : ");
        mirror_test(root);
        q.add(root);
        display(q);


    }
}
