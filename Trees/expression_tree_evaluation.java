/*
expression evaluation tree

Input : tree is given by default

Output :
100

 */
package Trees;

public class expression_tree_evaluation {

    static class node{
        String s;
        node left, right;
        node(String k){
            s = k;
            left = null;
            right = null;
        }
    }

    static int evaluation(node root){
        if(root == null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return Integer.parseInt(root.s);
        }

        int left = evaluation(root.left);
        int right = evaluation(root.right);

        if(root.s.equals("+")){
            return left+right;
        }
        else if(root.s.equals("-")){
            return left-right;
        }
        else if(root.s.equals("/")){
            return left/right;
        }
        else if(root.s.equals("*")){
            return left*right;
        }
        return 0;
    }

    public static void main(String[] args){

        node root = new node("+");
        root.left = new node("*");
        root.left.left = new node("5");
        root.left.right = new node("4");

        root.right = new node("-");
        root.right.left = new node("100");
        root.right.right = new node("20");

        System.out.println(evaluation(root));
    }
}
