/*
Given an array of positive integers. All numbers occur even number
of times except one number which occurs odd number of times.

Input:
9
1 2 3 2 1 2 3 4 4

Output:
2

 */
package Arrays_0;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;


public class number_repeated_odd_times {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer,Integer> m = new HashMap();
        ArrayList<Integer> l = new ArrayList();

        for(int i=0; i<n; i++){
            int x=sc.nextInt();
            if(m.containsKey(x))
                m.replace(x,m.get(x)+1);
            else{
                m.put(x,1);
                l.add(x);
            }
        }
        System.out.println(m);
        System.out.println(l);
        int count=0;
        for(int i=0;i<l.size();i++){
            if(m.get(l.get(i))%2!=0){
                System.out.println(l.get(i));
                count++;
                break;
            }
        }
        if(count==0)
            System.out.println("NO");

    }

}

