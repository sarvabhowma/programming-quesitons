package Trees;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class test {

    static class node{
        int value;
        node left, right;
        node(int k){
            value = k;
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

    static node t(int[] a, int i){
        if(i>a.length-1){
            return null;
        }
        node temp = new node(a[i]);

        temp.left = t(a,2*i+1);
        temp.right = t(a,2*i+2);

        return temp;
    }

    public static void main(String[] args) {

        int []a = {1,2,3,4,5,6,7,8,9};

        node root = t(a,0);

        Queue<node> q = new LinkedList<>();
        q.add(root);
        display(q);


        System.out.println("\n---------------");
        System.out.println(new ArrayList<Integer>(){{
            add(1);
        }});
    }
}
