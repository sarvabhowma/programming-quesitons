/*
Given two strings s and t of lengths m and n respectively,
return the minimum window substring of s such that every
character in t (including duplicates) is included in the window.
If there is no such substring, return the empty string "".

A substring is a contiguous sequence of characters within the string.

Input:
aksdjfakljsdhfasjdhfkajsndf
ald

Output:
djfakl

 */
package dynamic_programming;

import java.util.*;

public class minimum_window_substring {

    public static String minWindow(String s, String t) {

        if(s.length()==0 || t.length()==0 || s.length()<t.length()){
            return "";
        }

        Map<Character,Integer> m = new HashMap<>();
        Map<Character,Integer> win = new HashMap<>();

        int len = -1;
        int st = -1;
        int end = -1;

        int count = 0;

        for(char c: t.toCharArray()){
            int k = m.getOrDefault(c,0);
            m.put(c,k+1);
        }

        int l = 0;
        int r = 0;

        while(r<s.length()){
            char c = s.charAt(r);
            int k = win.getOrDefault(c,0);
            win.put(c,k+1);

            if(m.getOrDefault(c,-1).intValue()==win.get(c).intValue()){
                count++;
            }

            while(l<=r && count==m.size()){

                if(len==-1 || r-l+1<len){
                    len = r-l+1;
                    st = l;
                    end = r;
                }

                c = s.charAt(l);
                win.put(c,win.get(c)-1);

                if(m.getOrDefault(c,-1).intValue()>win.get(c).intValue()){
                    count--;
                }
                l++;
            }
            r++;
        }

        return len==-1?"":s.substring(st,end+1);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        System.out.println(minWindow(s,t));
    }
}
