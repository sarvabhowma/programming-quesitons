/*
grouping the numbers according to the given order

Input:
10
3 2 1 4 3 5 2 9 1 3

output:
3 3 3 2 2 1 1 4 5 9

 */
package Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class grouping_of_elements {

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        int a[] = new int[n];
        int b[] = new int[n];
        int k =0;

        for(int i = 0;i<n;i++){
            a[i] = sc.nextInt();
            if(map.containsKey(a[i])){
                map.replace(a[i],map.get(a[i])+1);
            }
            else {
                map.put(a[i], 1);
                b[k++] = a[i];
            }
        }

        k = 0;
        for(int i=0;i<map.size();i++){
            for(int j = 0; j<map.get(b[i]); j++)
                a[k++]=b[i];
        }

        for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");
    }
}


