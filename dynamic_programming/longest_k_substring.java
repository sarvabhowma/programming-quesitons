/*
Longest K unique characters substring :
Given a string you need to print the size of the longest
possible substring that has exactly K unique characters.
If there is no possible substring then print -1.

Input:
aabacbebebe
3

Output:
cbebebe
7

 */
package dynamic_programming;

import java.util.*;

public class longest_k_substring {

    public static int longestkSubstr(String s, int k) {
        if (s.length() < k) {
            return -1;
        }

        Map<Character, Integer> m = new HashMap<>();
        int len = -1;
        int st = -1;
        int end = -1;
        int l = 0;
        int r = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            int count = m.getOrDefault(c, 0);
            m.put(c, count + 1);

            if (m.size() > k) {

                while (l <= r && m.size() > k) {
                    c = s.charAt(l);
                    if (m.get(c) == 1) {
                        m.remove(c);
                    } else {
                        m.put(c, m.get(c) - 1);
                    }
                    l++;
                }

            }
            if (m.size() == k && len < r - l + 1) {
                len = r - l + 1;
                st = l;
                end = r;
            }
            r++;
        }
        if(len!=-1){
            System.out.println(s.substring(st,end+1));
        }
        return len;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = Integer.parseInt(sc.nextLine());

        System.out.println(longestkSubstr(s,k));
    }
}
