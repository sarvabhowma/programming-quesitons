/*
longest palindromic substring

Input:
emadamz

Output:
madam

 */

package dynamic_programming;

import java.util.Scanner;

public class longest_palindromic_substring {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int max = 1;
        int index = -1;

        for (int i = 0; i < s.length(); i++) {
            int l = i - 1;
            int r = i + 1;

// for odd length palindrome

            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    l = l - 1;
                    r = r + 1;
                } else {
                    break;
                }
            }
            if (max < r - l - 1) {
                max = r - l - 1;
                index = l + 1;
            }

// for even length palindrome

            l = i - 1;
            r = i;

            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    l = l - 1;
                    r = r + 1;
                } else {
                    break;
                }
            }

            if (max < r - l - 1) {
                max = r - l - 1;
                index = l + 1;
            }

        }
        System.out.println(s.substring(index, index + max));
    }
}



