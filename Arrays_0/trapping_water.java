/*
Trapping water problem.

Input:
10
1 0 2 0 1 0 3 1 0 2

Output:
9

 */

package Arrays_0;
import java.util.Scanner;

public class trapping_water {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();

        int x=0;
        int l[] = new int[n];

        l[0] = a[0];
        for(int i=1;i<n;i++){
            l[i] = Math.max(l[i-1],a[i]);
        }
        int r[] = new int[n];
        r[n-1] = a[n-1];
        for(int i=n-2;i>=0;i--){
            r[i]=Math.max(r[i+1],a[i]);
        }
        int sum = 0;

        for(int i=0;i<n;i++)
            sum += Math.min(l[i],r[i]) - a[i];
        System.out.println(sum);
    }

}
