/*
Find the maximum difference between two elements, such that larger
element appears after the smaller element.
input:
7
3 2 1 2 3 1 1

output:
2

 */
package Arrays_0;
import java.util.Scanner;

public class max_diff_m2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a=99999,b=0,max=-1;
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            b=arr[i];
            if(a>b)
                a=b;
            else if(b-a>max)
                max=b-a;

        }
        System.out.println(max);
    }

}
