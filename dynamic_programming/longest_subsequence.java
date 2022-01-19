/*
longest subsequence in an array, such that elements
in subsequence are consecutive

Input:
9
10 4 3 11 13 5 6 12 7

Output:
maximum length : 5
sequence : 3 4 5 6 7

 */

package dynamic_programming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class longest_subsequence {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        Map<Integer,Integer> m = new HashMap<>();

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
            if(!m.containsKey(a[i])){
                m.put(a[i],0);
            }
        }
        int min=99999;
        int length=0;

        for(int i=0;i<n;i++){
            int x = a[i];
            int count = 1;

            if(m.get(a[i])==1){
                continue;
            }

            m.replace(x,1);

            while(m.containsKey(x+1)){
                m.replace(x+1,1);
                x = x+1;
                count++;
            }
            x = a[i];
            while(m.containsKey(x-1)){
                m.replace(x-1,1);
                x = x-1;
                count++;
            }

            if(length<count){
                min = x;
                length = count;
            }
        }

        System.out.println("maximum length : "+length);
        System.out.print("sequence : ");

        while(m.containsKey(min)){
            System.out.print(min+" ");
            min++;
        }

    }
}
