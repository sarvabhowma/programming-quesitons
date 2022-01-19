/*
setting the kth bit in n to 1

Input:
7
4
Output:
15

Input:
2
4
Output:
10

 */
package Bit_Manipulation;

import java.util.Scanner;

public class set_kth_bit{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        n = n | (1<<k-1);

        System.out.println(n);

    }
}
