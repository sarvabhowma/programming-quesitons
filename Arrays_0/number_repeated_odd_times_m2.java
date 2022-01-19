/*
Given an array of positive integers. All numbers occur even number of times except one number
which occurs odd number of times.

Input:
9
1 2 3 2 1 2 3 4 4

Output:
2

 */

package Arrays_0;
import java.util.Scanner;

public class number_repeated_odd_times_m2 {

   public static void main(String[] args){

       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int a = 0;

       for(int i=0;i<n;i++){
           int x = sc.nextInt();
           a = a^x;
       }
       System.out.println(a);
   }

}


