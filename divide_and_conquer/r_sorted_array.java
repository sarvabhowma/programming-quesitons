/*
finding the given element in the rotated sorted array (7 8 9 10 1 2 3 4 5 6)

Input:
10 // size of the array
7 8 9 10 1 2 3 4 5 6
4 // element to be searched

Output:
yes : 8 // position of the element

 */
package divide_and_conquer;

import java.util.Scanner;

public class r_sorted_array{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        int l=0,r=n-1;

        while(l<r){
            int mid = (l+r)/2;

            if(a[mid]==k){
                l = mid;
                break;
            }
            else if(a[mid]<a[r]){
                if((k>a[mid]) && (k<=a[r])){
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }
            }
            else if(a[mid]>a[r]){
                if((k<a[mid]) && (k>=a[l])){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
        }
        if(a[l] == k){
            System.out.println("yes : "+(l+1));
        }
        else{
            System.out.println("no");
        }
    }
}