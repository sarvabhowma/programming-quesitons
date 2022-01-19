/*
finding the maximum element in an array

Input:
9
1 24 36 53 67 89 76 65 0

Output:
89

 */

package divide_and_conquer;

import java.util.Scanner;

public class maximum_element{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int l = 0, r=n-1;

        if(a.length==1){
            System.out.println(a[0]);
        }
        else if(a.length==2){
            if(a[0]>a[1]){
                System.out.println(a[0]);
            }
            else{
                System.out.println(a[1]);
            }
        }
        else{
            while(l<r){
                int mid = (l+r)/2;
                if((a[mid-1]<a[mid]) && (a[mid+1]<a[mid])){
                    l = mid;
                    break;
                }
                else if(a[mid-1]<a[mid] && a[mid+1]>a[mid]){
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }
                if(l==r){
                    break;
                }
            }
            System.out.println(a[l]);
        }
    }
}
