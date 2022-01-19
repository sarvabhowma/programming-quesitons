/*
toggle the kth bit in n
making it zero if it is one
or one if it is zero

Input:
7
4
Output:
15

Input:
15
4
Output:
7

 */

package Bit_Manipulation;

import java.util.Scanner;

public class toggle_kth_bit{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        n = n ^ (1<<(k-1));

        System.out.println(n);

    }
}