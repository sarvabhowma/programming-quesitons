/*
checking whether the kth bit in the given n is set or not

Input:
8
4
Output:
Set

Input:
7
4
Output:
Not Set

 */
package Bit_Manipulation;

import java.util.Scanner;

public class kth_bit{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        if((n & (1<<k-1))!=0){
            System.out.println("Set");
        }
        else{
            System.out.println("Not Set");
        }

    }
}
