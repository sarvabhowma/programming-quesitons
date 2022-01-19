/*
calculating the power of a given value

Input:
enter the base : 7
enter the power value : 5

Output:
16807

 */
package divide_and_conquer;

import java.util.Scanner;

public class power{

    static int pow(int x, int n){
        if(n==1){
            return x;
        }

        return pow(x,n/2)*pow(x,n-n/2);
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("enter the base : ");
        int x = sc.nextInt();

        System.out.print("enter the power value : ");
        int n = sc.nextInt();

        System.out.println(pow(x,n));
    }
}