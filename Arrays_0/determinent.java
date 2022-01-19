/*
Find the determinent of a matrix

Input:
3 //size of the matrix
1 2 3
4 5 6
7 8 8

Output:
3

 */

package Arrays_0;

import java.util.*;
import java.lang.Math;

public class determinent {

    public static int determinent(int [][]m,int n){

        if(n == 2){
            return (m[0][0]*m[1][1] - m[1][0]*m[0][1]);
        }

        int m1[][] = new int[n-1][n-1];
        int sum = 0;

        for(int j=0 ; j<n;j++){

            for(int k=1;k<n;k++)
                for(int l=0,x=0;l<n;l++){
                    if(l!=j){
                        m1[k-1][x] = m[k][l];
                        x++;
                    }
                }

            sum += m[0][j]*determinent(m1,n-1)*(Math.pow(-1,j));
        }

        return sum;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("enter the size of the matrix");
        int n = s.nextInt();
        int m[][] = new int[n][n];
        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++)
                m[i][j] = s.nextInt();
        }

        System.out.println(determinent(m,n));
    }
}
