/*
displaying the bottom view of a binary tree

Input : tree is given by default

Output :
5 12 15 30

 */
package Trees;

import java.util.HashMap;
import java.util.Map;

public class bottom_view_of_BT {

    static class node{
        int value;
        node left, right;
        node(int k){
            this.value = k;
            left = null;
            right = null;
        }
    }

    static void bottom_view(node root, Map<Integer, node> m, int[] a, int l){
        if(root==null){
            return;
        }
        if(m.containsKey(l)){
            m.replace(l,root);
        }
        else{
            m.put(l, root);
        }
        if(a[0]>l){
            a[0] = l;
        }
        if(a[1]<l){
            a[1] = l;
        }

        bottom_view(root.left, m, a, l-1);
        bottom_view(root.right, m, a, l+1);
    }

    public static void main(String[] args){

        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.left.right.left = new node(12);

        // min is a[0] and max is a[1]
        int a[] = new int[2];

        Map<Integer, node> m = new HashMap<>();

        bottom_view(root, m, a, 0);

        for(int i=a[0];i<=a[1];i++){
            System.out.print(m.get(i).value + " ");
        }
    }
}
