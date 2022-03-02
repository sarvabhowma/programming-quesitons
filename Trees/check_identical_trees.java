/*
checking whether the given two trees are same or not

Input :
it is given by default

Output :
Recursive Method : true
Iterative Method : true

 */

package Trees;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class check_identical_trees {

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
    static boolean check_r(node root1, node root2){
        if(root1==null && root2==null){
            return true;
        }
        else {
            if(root1!=null && root2!=null){
                return (root1.value == root2.value) ? (check_r(root1.left,root2.left) && check_r(root1.right,root2.right)) : false;
            }
            else
                return false;
        }
    }

    // iterative method
    static boolean check_i(node root1, node root2){
        Queue<node> q1 = new LinkedList<>();
        Queue<node> q2 = new LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while(q1.size()!=0 && q2.size()!=0){
            node temp1 = q1.peek();
            node temp2 = q2.peek();
            if(temp1.value == temp2.value){
                if(temp1.left!=null)
                    q1.add(temp1.left);
                if(temp1.right!=null)
                    q1.add(temp1.right);

                if(temp2.left!=null)
                    q2.add(temp2.left);
                if(temp2.right!=null)
                    q2.add(temp2.right);

                q1.remove();
                q2.remove();
            }
            else{
                return false;
            }
        }

        if((q1.size()!=0 && q2.size()==0) || (q1.size()==0 && q2.size()!=0)){
            return false;
        }

        return true;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        node root1 = new node(10);
        root1.left = new node(20);
        root1.right = new node(30);

        root1.left.left = new node(40);
        root1.left.right = new node(50);

        node root2 = new node(10);
        root2.left = new node(20);
        root2.right = new node(30);

        root2.left.left = new node(40);
        root2.left.right = new node(50);

        System.out.println("Recursive Method : "+check_r(root1, root2));

        System.out.println("Iterative Method : "+check_i(root1, root2));

    }
}
