/*
Interval scheduling algorithm

Input:
enter the number of pairs : 6
enter the pairs :
10 13
9 14
7 11
12 16
20 25
1 50

Output:
(7, 11)
(12, 16)
(20, 25)
3

 */
package Greedy_Algorithms;

import java.util.Scanner;
import java.util.Arrays;

public class interval_scheduling{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number of pairs : ");
        int n = sc.nextInt();
        int a[][] = new int[n][2];

        System.out.println("enter the pairs : ");
        for(int i=0;i<n;i++){
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }

        Arrays.sort(a,(b,c)->b[1]-c[1]);

        int count = 1;
        int f = a[0][1];
        System.out.println("("+a[0][0]+", "+a[0][1]+")");

        for(int i=1;i<n;i++){
            if(a[i][0]>f){
                count+=1;
                f = a[i][1];
                System.out.println("("+a[i][0]+", "+a[i][1]+")");
            }
        }

        System.out.println(count);

    }
}
