/*
checking whether the given is power of 2 or not

Input:
8
Output:
the given number is power of 2

Input:
10
Output:
the given number is not power of 2

 */

package Bit_Manipulation;

import java.util.Scanner;

public class power_of_two{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if((n&(n-1))==0 && n!=0){
            System.out.println("the given number is power of 2");
        }
        else{
            System.out.println("the given number is not power of 2");
        }

    }
}
