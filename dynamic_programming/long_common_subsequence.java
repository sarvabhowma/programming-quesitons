/*
longest common subsequence in the given two strings

Input:
star
sarva

Output:
1 1 1 1 1
1 1 1 1 1
1 2 2 2 2
1 2 3 3 3
1 2 3 3 3
3 // length
sar // characters

 */

package dynamic_programming;

import java.util.Scanner;

public class long_common_subsequence{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int m = s1.length(),n=s2.length();

        int a[][] = new int[m+1][n+1];
        String out = "";
        int count =0;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    a[i][j] = 1+a[i-1][j-1];
                }
                else{
                    a[i][j] = Math.max(a[i-1][j],a[i][j-1]);
                }
            }
        }

        int i=m,j=n;

        while(i>=1 && j>=1){

            if(s1.charAt(i-1)==s2.charAt(j-1)){
                out = s1.charAt(i-1)+out;
                i--;
                j--;
            }
            else if(a[i-1][j]>a[i][j-1]){
                i--;
            }
            else{
                j--;
            }

        }

        for(i=0;i<=m;i++){
            for(j=0;j<=n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(out);

    }
}