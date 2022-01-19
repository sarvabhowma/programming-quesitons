/*
clearing the kth bit in n
making it zero

Input:
15
4
Output:
7

Input:
9
1
Output:
8

 */
package Bit_Manipulation;

import java.util.Scanner;

public class clear_kth_bit{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        n = n & ~(1<<k-1);

        System.out.println(n);

    }
}
