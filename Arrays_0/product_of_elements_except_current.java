/*
Find product array such that product[i] is equal to product of all elements except product[i]
without using division operator.

Input:
5
10 3 5 6 2

Output:
180 600 360 300 900

 */
package Arrays_0;
import java.util.*;

public class product_of_elements_except_current {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []a = new int[n];
        int []right_prdct = new int[n];

        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();

        right_prdct[n-1] = a[n-1];

        for(int i=n-2;i>=0;i--)
            right_prdct[i] = a[i]*right_prdct[i+1];

        int result[] = new int[n];
        int left_prdct=1;

        for(int i=0;i<n-1;i++){
            result[i] = left_prdct*right_prdct[i+1];
            left_prdct *= a[i];
            System.out.print(result[i]+" ");
        }
        System.out.print(left_prdct);

    }

}

