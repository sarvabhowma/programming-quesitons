/*
multiplying the given number with 7

Input:
5
Output:
35

Input:
20
Output:
140

 */
package Bit_Manipulation;

import java.util.Scanner;

public class multiplication_with_seven {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        n = (n<<3) - n;
        System.out.println(n);
    }
}
