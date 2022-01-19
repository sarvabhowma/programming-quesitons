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

public class majority_element_m3 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> m = new HashMap<>();
        int n = sc.nextInt();
        int a[] = new int[n];
        int x=0;
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            if(m.containsKey(a[i])) {
                int count = m.get(a[i]) + 1;
                m.replace(a[i], count);
                if(count>n/2)
                    x = a[i];
            }
            else
                m.put(a[i],1);
        }
        if(x==0)
            System.out.println("NO");
        else
            System.out.println(x);
    }

}