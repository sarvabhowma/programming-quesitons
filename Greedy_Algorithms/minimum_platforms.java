/*
minimum number of platforms required
a -> trains arrival times
b -> trains departure times

Input:
enter the number of trains : 4
0 20
15 60
30 65
40 55

Output:
total platforms needed is : 3

 */

package Greedy_Algorithms;

import java.util.Scanner;
import java.util.Arrays;

public class minimum_platforms {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number of trains : ");
        int n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);
        int min_platforms = 0;
        int count = 1;
        int i=1,j=0;

        while(i<n){
            if(a[i]<b[j]){
                count++;
                i++;
                if(min_platforms<count){
                    min_platforms = count;
                }
            }
            else{
                count--;
                j++;
            }
        }

        System.out.println("total platforms needed is : "+min_platforms);

    }
}
