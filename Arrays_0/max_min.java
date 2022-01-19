/*
finding the maximum and minimum value in a array

Input:
7 // size of the array
12 43 23 64 232 86 94

Output:
Maximum value : 232
Minimum value : 12

 */

package Arrays_0;

import java.util.Scanner;

public class max_min{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a[] = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        int i=0;
        int max, min;

        if(n%2==0){
            if(a[0]>a[1]){
                max = a[0];
                min = a[1];
            }
            else{
                max = a[1];
                min = a[0];
            }
            i=2;
        }
        else{
            max = a[0];
            min = a[0];
            i=1;
        }

        while(i<n-1){

            int curr_max;
            int curr_min;

            if(a[i]>a[i+1]){
                curr_max = a[i];
                curr_min = a[i+1];
            }
            else{
                curr_max = a[i+1];
                curr_min = a[i];
            }

            if(max<curr_max){
                max = curr_max;
            }
            if(min>curr_min){
                min = curr_min;
            }

            i = i+2;
        }

        System.out.println("Maximum value : "+max);
        System.out.println("Minimum value : "+min);

    }
}
