/*
check whether the given string has matching parenthesis or not

Input:
([]{}[]){}()([{}])

Output:
Matching Parenthesis

Input:
({[]}){[]{}()

Output:
Not Matching Parenthesis
[{]

 */

package Stacks;

import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

public class parenthesis {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        String s;
        HashMap<String,String> map = new HashMap<>();
        Stack<String> st = new Stack<>();

        map.put(")","(");
        map.put("}","{");
        map.put("]","[");

        s = sc.nextLine();

        for(int i = 0;i<s.length();i++){

            String t = String.valueOf(s.charAt(i));

            if(map.containsKey(t) && st.peek().equals(map.get(t))){
                st.pop();
            }
            else{
                st.push(t);
            }

        }

        if(st.size()==0){
            System.out.println("Matching Parenthesis");
        }
        else{
            System.out.println("Not Matching Parenthesis");
            System.out.println(st);
        }

    }
}
