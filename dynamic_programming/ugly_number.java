/*
finding the kth ugly number
ugly number : the number whose factors or 2,3,5 only
repetition is allowed

Input:
13 // k value

Output:
kth ugly number is : 18

 */
package dynamic_programming;

import java.util.Scanner;

public class ugly_number{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int u[] = new int[k];

        int x=0,y=0,z=0;
        u[0] = 1;

        for(int i=1;i<k;i++){
            int min = Math.min(Math.min(2*u[x],3*u[y]),5*u[z]);
            u[i] = min;
            if(min == 2*u[x]){
                x++;
            }
            if(min == 3*u[y]){
                y++;
            }
            if(min == 5*u[z]){
                z++;
            }
        }

        System.out.println("kth ugly number is : "+u[k-1]);
    }
}