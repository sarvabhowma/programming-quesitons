/*
finding the next largest number for the given number with the same digits

Input :
12453

Output :
12534

 */

package Maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class next_large_number {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = n;

        ArrayList<Integer> list = new ArrayList<>();

        int l = n%10;
        m = n/10;
        list.add(l);

        while(true){

            if(m%10<l){

                list.remove(list.size()-1);
                list.add(m%10);

                m = m/10;
                break;
            }
            else{
                l = m%10;
                list.add(l);
                m = m/10;
            }

        }

        m = m*10+l;
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            m = m*10+list.get(i);
        }
        System.out.println(m);
    }
}
