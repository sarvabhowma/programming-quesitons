/*
generating the parenthesis

Input:
3

Output:
((()))
(()())
(())()
()(())
()()()

 */
package backtracking;

import java.util.Scanner;

public class gen_parenthesis {

    static void gen_parenthesis(int left, int right,String s,int l){
        if(left<0 || right<0 || right<left){
            return;
        }
        if(l==0){
            System.out.println(s);
            return;
        }

        gen_parenthesis(left-1,right,s+"(",l-1);
        gen_parenthesis(left,right-1,s+")",l-1);

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = "";
        gen_parenthesis(n,n,s,2*n);
    }
}
