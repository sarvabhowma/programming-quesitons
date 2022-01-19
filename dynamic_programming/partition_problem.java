/*
checking whether it is possible to divide an
array into 2-sets and the sum of elements in
the sets are equal

Input:
6
4 10 5 15 3 1

Output:
possible
 */
package dynamic_programming;

import java.util.Scanner;

public class partition_problem{

    static void partition(int[][] c,int[] a,int sum, int n){

        for(int i=0;i<n+1;i++){
            c[0][i] = 1;
        }

        for(int i=1;i<sum/2+1;i++){
            for(int j=1;j<n+1;j++){
                c[i][j] = c[i][j-1];
                if(i>=a[j-1]){
                    if(c[i][j]==1 || c[i-a[j-1]][j]==1){}
                        c[i][j] = 1;
                }

            }
        }
        return;

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int sum = 0;

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
            sum +=a[i];
        }

        if(sum%2==0){

            int [][]c = new int[sum/2+1][n+1];
            partition(c,a,sum,n);
//            for(int i=0;i<sum/2+1;i++){
//                for(int j=0;j<n+1;j++){
//                    System.out.print(c[i][j]);
//                }
//                System.out.println();
//            }
            if(c[sum/2][n]==1){
                System.out.println("possible");
            }
            else{
                System.out.println("not possible");
            }
        }
        else{
            System.out.println("not possible");
        }

    }
}