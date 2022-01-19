/*
Given two string X and Y of length N and M respectively.
The task is to find the length of the longest subsequence
of string X which is a substring in sequence Y.

Input:
staurivwae
sarvabhowma

Output:
0 0 0 0 0 0 0 0 0 0 0
0 1 1 1 1 1 1 1 1 1 1
0 0 0 2 2 2 2 2 2 2 2
0 0 0 0 0 3 3 3 3 3 3
0 0 0 0 0 0 0 4 4 4 4
0 0 0 1 1 1 1 1 1 5 5
0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 1 1 1
0 0 0 0 0 0 0 0 0 0 0
0 0 0 1 1 1 1 1 1 1 1
sarva
5
 */

package dynamic_programming;

import java.util.*;

public class longest_subsequence_substring {

    static int maxSubsequenceSubstring(String X, String Y, int N, int M)
    {
        int a[][] = new int[M+1][N+1];
        int max = 0;
        int idx = -1;

        for(int i=1;i<=M;i++){
            for(int j=1;j<=N;j++){
                if(Y.charAt(i-1)==X.charAt(j-1)){
                    a[i][j] = a[i-1][j-1]+1;
                }
                else{
                    a[i][j] = a[i][j-1];
                }
                if(max<a[i][j]){
                    max = a[i][j];
                    idx = i-1;
                }
            }
        }

        for(int i=0;i<=M;i++){
            for(int j=0;j<=N;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(Y.substring(idx-max+1,idx+1));

        return max;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        System.out.println(maxSubsequenceSubstring(s1,s2,s1.length(),s2.length()));
    }
}
