/*
finding the length of the longest palindromic subsequence
in the given string

Input:
abcdefdcba

Output:
1 1 1 1 1 1 3 5 7 9
0 1 1 1 1 1 3 5 7 7
0 0 1 1 1 1 3 5 5 5
0 0 0 1 1 1 3 3 3 3
0 0 0 0 1 1 1 1 1 1
0 0 0 0 0 1 1 1 1 1
0 0 0 0 0 0 1 1 1 1
0 0 0 0 0 0 0 1 1 1
0 0 0 0 0 0 0 0 1 1
0 0 0 0 0 0 0 0 0 1
9 // abcdedcba

 */

package dynamic_programming;

import java.util.Scanner;

public class long_palindromic_subsequence{

    static int lps(String s){
        int n = s.length();
        int a[][] = new int[n][n];

        for(int i=0;i<n;i++){
            a[i][i] = 1;
        }

        for(int i=1;i<n;i++){
            int k = 0;
            for(int j=i;j<n;j++){
                if(i==1 && s.charAt(k)==s.charAt(j)){
                    a[k][j] = 2;
                }
                else if(s.charAt(k)==s.charAt(j)){
                    a[k][j] = 2 + a[k+1][j-1];
                }
                else{
                    a[k][j] = Math.max(a[k][j-1],a[k+1][j]);
                }
                k++;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        return a[0][n-1];
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(lps(s));
    }
}