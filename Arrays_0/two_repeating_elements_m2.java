/*
Find two repeating elements in an array.

Input:
7
2 4 2 5 4 3 1

Output:
2 4

 */
package Arrays_0;
import java.util.*;

public class two_repeating_elements_m2 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();

        for(int i=0;i<n;i++){
            int x = Math.abs(a[i]);
            if(a[x]<0)
                System.out.print(x+" ");
            a[x] = -a[x];
//            System.out.println(a[x]);
        }

    }

}
