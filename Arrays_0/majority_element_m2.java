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

public class majority_element_m2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int voter=0,votes=0;
        for(int i=0;i<n;i++) {
            a[i] = sc.nextInt();
            if(votes==0){
                voter=a[i];
                votes++;
            }
            else if(votes!=0 && voter == a[i])
                votes++;
            else
                votes--;
        }
        int count=0;
        for(int i=0;i<n;i++)
            if(a[i]==voter){
                count++;
                if(count>n/2){
                    System.out.println(voter);
                    break;
                }
            }
        if(count<n/2+1)
            System.out.println("NO");
    }

}


