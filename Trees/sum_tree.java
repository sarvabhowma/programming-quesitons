/*
checking whether the given tree is sum tree or not, sum tree means the value of root is equal to
the sum of left tree value and right tree value

Input : tree is given by default

Output :
TRUE

 */
package Trees;


public class sum_tree {

    static class node {
        int value;
        node left, right;

        node(int k) {
            this.value = k;
            left = null;
            right = null;
        }
    }

    static int is_sum_tree(node root){
        if(root == null){
            return 0;
        }
        if(root.left==null && root.right==null) {
            return root.value;
        }
        int left = is_sum_tree(root.left);
        int right = is_sum_tree(root.right);
        if(root.value == left+right){
            return root.value + left + right;
        }
        return -1;
    }

    public static void main(String[] args) {

        node root = new node(26);
        root.left = new node(10);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(6);
        root.right.left = new node(1);
        root.right.right = new node(2);

        if (is_sum_tree(root) != -1) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }
}

