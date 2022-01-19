/*
no of times sec string occurring in first string

Input:
abbabbaaabba
abba

Output:
3

 */
package Pattren_Matching;

import java.util.Scanner;

public class string_occurences{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int count = 0;
        int n = s1.length();
        int m = s2.length();

        for(int i=0;i<n-m+1;i++){
            if(s1.substring(i,i+m).equals(s2)){
                count+=1;
            }
        }

        System.out.println(count);

    }
}
