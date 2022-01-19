/*

Separate 0's and 1's in an array.

Input:
8
1 0 1 0 1 0 1 1

Output:
0 0 0 1 1 1 1 1

 */
package Arrays_0;
import java.util.*;

public class Seperate_0_and_1_m1 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> m=new HashMap();
        int n=sc.nextInt();
        int []a=new int[n];
        m.put(0,0);
        m.put(1,0);
        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
            if(a[i]==0)
                m.replace(0,m.get(0)+1);
            else
                m.replace(1,m.get(1)+1);
        }
//        System.out.println(m);
        for(int i=0; i<n;i++){
            if(i<m.get(0))
                System.out.print("0 ");
            else
                System.out.print("1 ");
        }

    }

}
