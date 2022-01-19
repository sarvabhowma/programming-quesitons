/*
minimum number of brackets need to be reversed to make the string balanced

Input:
}}}{{}}{{{

Output:
[}, }, }, {, {, {]
4

 */

package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class min_no_of_bracket_reversal {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        Stack<String> st = new Stack<>();
        String s = sc.nextLine();

        if(s.length()%2==1){
            System.out.println("Not Possible");
            System.exit(0);
        }

        st.push(String.valueOf(s.charAt(0)));

        for (int i = 1; i < s.length(); i++) {

            String t = String.valueOf(s.charAt(i));

            if (st.peek().equals("{") && t.equals("}")) {
                st.pop();
            } else {
                st.push(t);
            }
        }

        int unbalanced_length = st.size();
        int n = 0;

        System.out.println(st);

        while (st.peek().equals("{")) {
            n += 1;
            st.pop();
        }

        System.out.println(unbalanced_length / 2 + n % 2);
    }
}
