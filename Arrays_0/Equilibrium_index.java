/*
finding the equilibrium index in the given array
the index at which the right sum is equal to the
left sum

Input:
7
7 2 1 4 6 4 0

Output:
4

 */
package Arrays_0;

import java.util.*;

public class Equilibrium_index {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int total_sum=0,curr_sum=0;
        int []a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            total_sum+=a[i];
        }

        int count=0;
        for(int i=0;i<n;i++){
            if(total_sum==2*curr_sum+a[i]){
                System.out.println(i+1);
                count++;
                break;
            }
            curr_sum+=a[i];
        }
        if(count==0)
            System.out.println("NO");
    }

}
