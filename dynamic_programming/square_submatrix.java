/*
For a given binary square matrix finding the largest,
square sub matrix with all 1's.

Input:
4
1 1 1 1
0 0 1 1
1 1 1 1
0 1 1 1

Output:
1 1 1 1
0 0 1 2
1 1 1 2
0 1 2 2
maximum square sub matrix with 1's : 2

 */
package dynamic_programming;

import java.util.Scanner;

public class square_submatrix{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j] = sc.nextInt();
            }
        }

        int max = 0;

        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                if(a[i][j]!=0){
                    a[i][j] += Math.min(Math.min(a[i-1][j],a[i][j-1]),a[i-1][j-1]);
                }
                if(max<a[i][j]){
                    max = a[i][j];
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("maximum square submatrix with 1's : "+max);

    }

}