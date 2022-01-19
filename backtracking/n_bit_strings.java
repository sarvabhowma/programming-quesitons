/*
generating all possible n-bit strings

Input:
2

Output:
00
01
10
11

 */

package backtracking;

import java.util.Scanner;

public class n_bit_strings{

    static void generate(char a[], int count, int n){
        if(count==n){
            System.out.println(new String(a));
            return ;
        }
        a[count] = '0';
        generate(a,count+1,n);
        a[count] = '1';
        generate(a,count+1,n);
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char a[] = new char[n];
        generate(a,0,n);
    }
}
