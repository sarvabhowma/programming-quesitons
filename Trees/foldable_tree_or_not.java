/*
checking whether a tree is foldable or not

Input: tree is given by default

Output:
true

 */
package Trees;

public class foldable_tree_or_not {

    static class node{
        int value;
        node left, right;
        node(int k){
            left = null;
            right = null;
        }
    }

    static boolean foldable(node r1, node r2){
        if(r1==null && r2==null){
            return true;
        }
        if(r1==null || r2==null){
            return false;
        }

        return foldable(r1.left,r2.right) && foldable(r1.right,r2.left);
    }

    public static void main(String[] args){

        node root = new node(25);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.right.left = new node(28);
        root.right.right = new node(35);
        root.left.right.left = new node(12);
        root.right.left.right = new node(29);

        System.out.println(foldable(root.left,root.right));

    }
}
