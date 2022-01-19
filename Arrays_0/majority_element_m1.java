/*
find the element which is repeated more than half the size of the array

Input:
9
1 2 2 3 3 3 3 3 1

Output:
3

 */

package Arrays_0;
import java.util.*;

public class majority_element_m1 {

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n ;i++)
            a[i]=sc.nextInt();
        Arrays.sort(a);
        int x = n/2 + 1;
        int c=0;
        for(int i=0;i<n-x+1;i++){
            if(a[i]==a[i+x-1]){
                System.out.println(a[i]);
                c++;
            }
        }
        if(c==0)
            System.out.println("NO");
    }

}
