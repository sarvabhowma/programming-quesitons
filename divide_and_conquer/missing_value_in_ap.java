/*
finding the missing value in a arithmetic series

Input:
10
-2 0 2 4 6 8 12 14 16 18 20

Output:
10

 */
package divide_and_conquer;

import java.util.Scanner;

public class missing_value_in_ap{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        int d = (a[n-1]-a[0])/n;
        int l = 0,r = n-1,x=-1;

        while(l<=r){
            int mid = (l+r)/2;
            x = a[0]+(mid)*d;
            int left = a[0]+(mid-1)*d;

            if((x!=a[mid]) && (left == a[mid-1])){
                l = mid;
                break;
            }
            else if(x==a[mid]){
                l = mid+1;
            }
            else{
                r = mid-1;
            }

        }

        System.out.println(a[0]+(l)*d);
    }
}