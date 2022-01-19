/*
Given an array of positive integers, find the smallest number that cannot be formed
with sum of numbers from an array.

Input:
5
1 2 3 4 5
Output:
16
 */

package Arrays_0;
import java.util.*;

public class smallest_sum_cannot_be_formed {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();

        Arrays.sort(a);

        int min =1,count =0;

        for(int i=0;i<n;i++){
            if(a[i]<=min)
                min +=a[i];
            else{
                System.out.println(min);
                count++;
                break;
            }
        }
        if(count == 0)
            System.out.println(min);

    }

}

