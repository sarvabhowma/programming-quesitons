/*
minimum number of deletions are required to make
a string a palindrome

Input:
abcxba

Output:
abcba
minimum deletion : 1

 */

package dynamic_programming;

import java.util.Scanner;

public class k_palindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder s2 = new StringBuilder(sc.nextLine());
        String s1 = s2.toString();
        s2.reverse();

        int count = 0;
        int a[][] = new int[s1.length() + 1][s1.length()+1];
        String o = "";

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s1.length(); j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    a[i][j] = 1 + a[i - 1][j - 1];
                } else {
                    a[i][j] = Math.max(a[i - 1][j], a[i][j - 1]);
                }

                if (count < a[i][j]) {
                    count = a[i][j];
                    o += s1.charAt(i - 1);
                }

            }
        }

        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s1.length();j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(o);
        System.out.println("minimum deletion : "+(s1.length()-count));

    }
}