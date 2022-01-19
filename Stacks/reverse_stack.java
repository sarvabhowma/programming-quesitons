/*
reverse the stack using recursion

Input:
5
1 2 3 4 5

Output:
[1, 2, 3, 4, 5] // before the reverse
[5, 4, 3, 2, 1] // after the reverse

 */

package Stacks;

import java.util.Stack;
import java.util.Scanner;

public class reverse_stack {

    static Stack<Integer> reverse(Stack<Integer> s1,Stack<Integer> s2){
        if(s1.size()!=0){
            int k = s1.pop();
            s2.push(k);
            s2 = reverse(s1,s2);
        }
        return s2;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        for(int i=0;i<n;i++){
            s1.push(sc.nextInt());
        }

        System.out.println(s1);

        s1 = reverse(s1,s2);

        System.out.println(s1);


    }
}
