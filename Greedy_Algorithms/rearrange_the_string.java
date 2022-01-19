/*
rearranging the string such that same characters are
'd'--distance away

Input:
abcdada
2 // d-value

Output:
adbadca

 */
package Greedy_Algorithms;

import java.util.Scanner;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Arrays;

public class rearrange_the_string{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int d = sc.nextInt();
        Map<Character, Integer> m = new LinkedHashMap<>();
        char c1[] = new char[s.length()];
        int i=0;

        for(char c: s.toCharArray()){
            if(!m.containsKey(c)){
                m.put(c,1);
            }
            else{
                m.replace(c,m.get(c)+1);
            }
            c1[i++] = '0';
        }

        char [][]a = new char[m.size()][2];
        i = 0;

        for(char c: m.keySet()){
            a[i][0] = c;
            a[i][1] = (char)((int)m.get(c)+'0');
            i++;
        }

        Arrays.sort(a,(b,c)->(int)c[1]-(int)b[1]);

        for(i=0;i<a.length;i++) {

            char c = a[i][0];
            int count = (int)a[i][1]-48;

            for (int j = i; j < s.length(); j += (d+1)) {

                while (c1[j] != '0') {
                    if(j<s.length()){
                        j++;
                    }
                }
                c1[j] = c;
                count -=1;
                if(count==0){
                    break;
                }

            }
        }

        System.out.println(new String(c1));
    }
}