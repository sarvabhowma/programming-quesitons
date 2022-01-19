/*
check whether the given string has redundant parenthesis or not

Input:
((1+2)*(3+4))

Output:
No Redundant Parenthesis

Input:
(((1+2))*(3+4))

Output:
Redundant Parenthesis

 */

package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class redundent_parenthesis {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        Stack<String> st = new Stack<>();

        String s = sc.nextLine();
        int flag = 0;
        st.push(String.valueOf(s.charAt(0)));

        for (int i = 1; i < s.length(); i++) {

            if (st.size() != 0) {
                if (st.peek().equals("(") && s.charAt(i) == ')') {
                    flag = 1;
                    break;
                } else if (s.charAt(i) == ')') {
                    while (!st.peek().equals("(")) {
                        st.pop();
                    }
                    st.pop();
                } else {
                    st.push(String.valueOf(s.charAt(i)));
                }
            }
        }

        if (flag == 1) {
            System.out.println("Redundant Parenthesis");
        } else {
            System.out.println("No Redundant Parenthesis");
        }
    }
}
