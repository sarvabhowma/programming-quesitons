/*
boyer moore - string matching algorithm

Input:
which finally halts at that point
at that

Output:
at that

 */
package Pattren_Matching;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class boyer_moore {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        Map<Character,Integer> m = new HashMap<>();

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (!m.containsKey(c)) {
                m.put(c, i);
            }
        }

        int i = s2.length() - 1;

        while (i < s1.length()) {

            int j = s2.length() - 1;
            int k = i;

            while (j >= 0 && s1.charAt(k) == s2.charAt(j)) {
                k--;
                j--;
            }

            if (j < 0) {
                System.out.println(s1.substring(i - s2.length()+1, i + 1));
                i++;
            } else if (m.containsKey(s1.charAt(k))) {
                i += j - m.get(s1.charAt(k));
            } else {
                i += s2.length();
            }

        }


    }
}
