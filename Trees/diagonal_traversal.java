/*
displaying diagonal elements

Input : tree is given by default

Output :
25 30 37
10 15 28
5 12

 */
package Trees;

import java.util.HashMap;
import java.util.Map;

public class diagonal_traversal {

    static class node {
        int value;
        node left, right;

        node(int k) {
            value = k;
            left = null;
            right = null;
        }
    }

    static int diagonal(node root, Map<Integer, node> m, int d, int max) {
        if(root==null){
            return max;
        }
        if(m.containsKey(d)){
            node temp = m.get(d);
            while(temp.right!=null){
                temp = temp.right;
            }
            temp.right = new node(root.value);
        }
        else{
            m.put(d,new node(root.value));
        }
        if(max<d){
            max = d;
        }
        int l = diagonal(root.left,m,d+1,max);
        int r = diagonal(root.right,m,d,max);
        return Math.max(l,r);
    }

    public static void main(String[] args) {

        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.right.left = new node(28);
        root.right.right = new node(37);
        root.left.right.left = new node(12);

        Map<Integer, node> m = new HashMap<>();
        int d = 0, max = 0;

        max = diagonal(root, m, d, max);

        for (int i = 0; i <= max; i++) {
            node temp = m.get(i);
            while (temp != null) {
                System.out.print(temp.value + " ");
                temp = temp.right;
            }
            System.out.println();
        }
    }
}