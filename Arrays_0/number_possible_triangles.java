/*
Total number of triangles possible with given elements.

Input:
7
6 7 8 10 12 14 50

Output:
18

 */
package Arrays_0;
import java.util.*;

public class number_possible_triangles {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []a = new int[n];

        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();

        Arrays.sort(a);
        int sum = 0;
        for(int i=n-1;i>1;i--){
            int l=0,r=i-1;
            while(l<r){
                if(a[l]+a[r]>a[i]){
                    sum += r-l;
                    r--;
                }
                else {
                    l++;
                }
            }
        }
        System.out.println(sum);

    }

}
