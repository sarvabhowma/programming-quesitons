/*
the stock_span problem

Input:
6
10 4 5 90 120 80

Output:
0 0 1 3 4 0

 */

package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class stock_span {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        int n = sc.nextInt();

        int a[] = new int[n];
        int b[] = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        st.push(0);
        b[0] = 0;
        for(int i=1;i<n;i++){

            while((st.size()!=0) && (a[st.peek()]<=a[i])){
                st.pop();
            }
            if(st.size()==0){
                b[i] = i;
            }
            else{
                b[i] = i-st.peek()-1;
            }
            st.push(i);
        }

        for(int i=0;i<n;i++){
            System.out.print(b[i]+" ");
        }

    }
}
