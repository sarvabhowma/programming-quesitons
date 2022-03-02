package Trees;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class boundary_traversal {

    static class node {
        int value;
        node left, right;

        node(int k) {
            value = k;
            left = null;
            right = null;
        }
    }

    static int traversal(node root, Map<Integer, ArrayList<Integer>> m, int l) {
        if (root == null) {
            return l - 1;
        }
        if (!m.containsKey(l)) {
            m.put(l, new ArrayList<Integer>());
            m.get(l).add(root.value);
        }
        else{
            m.get(l).add(root.value);
        }
        int left = traversal(root.left,m,l+1);
        int right = traversal(root.right,m,l+1);
        return Math.max(left, right);
    }

    public static void main(String[] args) {

        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.left.right.left = new node(12);
        root.right.left = new node(27);
        root.right.right = new node(35);

        Map<Integer, ArrayList<Integer>> m = new HashMap<>();

        int max = traversal(root, m, 0);
        System.out.println(m);

        for(int i=0;i<max;i++){
            System.out.print(m.get(i).get(0)+" ");
        }
        for(int i: m.get(max)){
            System.out.print(i+" ");
        }
        for(int i=max-1;i>0;i--){
            int s = m.get(i).size()-1;
            System.out.print(m.get(i).get(s)+" ");
        }

    }
}
