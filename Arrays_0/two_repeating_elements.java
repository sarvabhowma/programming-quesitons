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

public class two_repeating_elements {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x=0,y=0;
        Map<Integer,Integer> m = new HashMap<>();

        int []a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
            if(m.containsKey(a[i])){
                if(x!=0)
                    y=a[i];
                else
                    x=a[i];
                m.replace(a[i],m.get(a[i])+1);
            }
            else
                m.put(a[i],1);
        }
        System.out.println(m);
        System.out.println(x+" "+y);
    }

}
