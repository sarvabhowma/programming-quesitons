/*
Nth natural number after removing all numbers consisting of the digit 9
 */
package Maths;

import java.util.Scanner;

public class nth_natural_number {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long out = 0;
        long p = 1;
        while(N>0){
            out += p*(N%9);
            p *= 10;
            N = N/9;
        }
        System.out.println(out);
    }
}
