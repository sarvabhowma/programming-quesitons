/*
counting the no of ones in the given n

Input:
7
Output:
3

Input:
8
Output:
1
 */

package Bit_Manipulation;

import java.util.Scanner;

public class set_bits_count{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        while(n!=0){

            count += n&1;
            n = n>>1;
        }

        System.out.println(count);

    }
}
