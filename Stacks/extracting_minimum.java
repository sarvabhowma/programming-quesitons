/*
extracting minimum value from the stack from the end in the array

Input:
5 // array size
45 30 89 2 90

Output:
Stack value : 90, minimum value : 2
Stack value : 2, minimum value : 2
Stack value : 89, minimum value : 30
Stack value : 30, minimum value : 30
Stack value : 45, minimum value : 45

 */

package Stacks;

import java.util.Stack;
import java.util.Scanner;

public class extracting_minimum{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Stack<Integer> s = new Stack<>();

        int n = sc.nextInt();
        int curr_mini = 99999999;

        for(int i = 0;i<n;i++){
            int k = sc.nextInt();
            if(k<curr_mini){
                k = k - curr_mini;
                curr_mini += k;
            }
            s.push(k);
        }

        while(s.size()!=0){
            int k = s.pop();
            if(k<curr_mini){
                int x = curr_mini;
                curr_mini -= k;
                k = x;
                System.out.println("Stack value : "+k+", minimum value : "+k);
            }
            else
                System.out.println("Stack value : "+k+", minimum value : "+curr_mini);

        }

    }
}