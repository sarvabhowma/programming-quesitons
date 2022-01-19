/*
For a given list of pairs print only mutually exclusive pairs

Input:
enter the number of pairs : 2
enter the pairs
1 2
2 10

Output:
After sorting based on sec index
1 , 2
2 , 10

Mutually Exclusive
1 , 10

 */

package Arrays_0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class mutually_exclusive_intervals {

    static class pair{
        int first;
        int sec;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number of pairs : ");
        int n = sc.nextInt();
        int a[][] = new int[n][2];
        ArrayList<pair> l = new ArrayList<>();

        System.out.println("enter the pairs");
        for(int i=0;i<n;i++){
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
            if(a[i][1]<a[i][0]){
                System.out.println("enter valid input");
                i=i-1;
            }
        }

        Arrays.sort(a, (b, c) -> Double.compare(b[1], c[1]));

        System.out.println("\nAfter sorting based on sec index");

        for(int i=0;i<n;i++){
            System.out.println(a[i][0]+" , "+a[i][1]);
        }

        pair p = new pair();
        p.first = a[0][0];
        p.sec = a[0][1];

        l.add(p);

        for(int i=1;i<n;i++){

            if(a[i][0]<=l.get(l.size()-1).sec){
                l.get(l.size()-1).sec = a[i][1];

                if(a[i][0]<l.get(l.size()-1).first)
                    l.get(l.size()-1).first = a[i][0];
            }

            else{
                pair q = new pair();
                q.first = a[i][0];
                q.sec = a[i][1];
                l.add(q);
            }

        }

        System.out.println("\nMutually Exclusive");

        for(int i = 0;i<l.size();i++){
            System.out.println(l.get(i).first +" , "+l.get(i).sec);
        }

    }
}
