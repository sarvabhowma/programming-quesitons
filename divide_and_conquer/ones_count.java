/*
given an array containing 1's and 0's in which 0's appear
before all 1's then count number of 1's in an array

Input:
10
0 0 0 0 0 0 1 1 1 1

Output:
no of ones : 4

 */
package divide_and_conquer;

import java.util.Scanner;

public class ones_count {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        int l=0,r=n-1;

        while(l<=r){
            int mid = (l+r)/2;
            if((a[mid]==1) && (a[mid-1]==0)){
                l = mid;
                break;
            }
            else if(a[mid]==1){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }

        System.out.println("no of ones : "+(n-l));
    }
}
