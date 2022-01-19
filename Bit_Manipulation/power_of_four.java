/*
checking whether the given number is power of 4 or not

Input:
16
Output:
given number is power of 4

Input:
20
Output:
given number is not power of 4

 */
package Bit_Manipulation;

import java.util.Scanner;

public class power_of_four {

public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    while((n%4)==0){
        n = n/4;
    }
    if(n==1){
        System.out.println("given number is power of 4");
    }
    else{
        System.out.println("given number is not power of 4");
    }
}
}
