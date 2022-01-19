/*
counting the number of palindromic substrings

Input:
madam

Output:
palindrome check :

1 0 0 0 1
0 1 0 1 0
0 0 1 0 0
0 0 0 1 0
0 0 0 0 1

palindrome count matrix :

1 2 3 5 7
0 1 2 4 5
0 0 1 2 3
0 0 0 1 2
0 0 0 0 1
7

 */

package dynamic_programming;

import java.util.Scanner;

public class palindromic_strings_count{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();

        int a[][] = new int[s.length()][s.length()];
        int b[][] = new int[s.length()][s.length()];

        for(int i=0;i<n;i++){
            a[i][i] = 1;
            b[i][i] = 1;
        }

        for(int i=1;i<n;i++){
            int k = 0;
            for(int j = i;j<n;j++){

                if(s.charAt(k)==s.charAt(j) && i==1){
                    a[k][j] = 1;
                }
                else if(s.charAt(k)==s.charAt(j) && a[k+1][j-1]==1){
                    a[k][j] = 1;
                }
                k++;
            }
        }

        System.out.println("\npalindrome check : \n");

        for(int i=0;i<n;i++){
            for( int j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        for(int i=1;i<n;i++){
            int k = 0;
            for(int j=i;j<n;j++){
                b[k][j] = b[k+1][j]+b[k][j-1];

                if(a[k][j]==1){
                    b[k][j] +=1;
                }
                if(i!=1){
                    b[k][j] -= b[k+1][j-1];
                }
                k++;

            }
        }

        System.out.println("\npalindrome count matrix : \n");

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(b[0][n-1]);

    }
}

