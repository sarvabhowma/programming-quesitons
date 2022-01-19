/*
finding the next higher number which is a power of 2

Input:
6
Output:
8.0

Input:
8
Output:
16.0

 */
package Bit_Manipulation;

import java.util.Scanner;

public class next_higher_number {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // m1 -> not work for all cases
        int p = (int)Math.ceil(Math.log(n))+1;
        System.out.println(Math.pow(2,p));

        // m2
        int count =1;

        while(n!=0){
            count += n&1;
            n = n>>1;
        }

        System.out.println(Math.pow(2,count));
    }
}
