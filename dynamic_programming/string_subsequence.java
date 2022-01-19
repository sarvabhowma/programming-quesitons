/*
counting the number of times string-2 occurred
as a sub sequence in string-1

Input:
abbab
ab

Output:
1 0 0
1 1 0
1 1 1
1 1 2
1 2 2
1 2 4
count for the occurrence of s2 in s1 as a sub sequence : 4

 */
package dynamic_programming;

import java.util.Scanner;

public class string_subsequence{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int cost[][] = new int[s1.length()+1][s2.length()+1];

        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                if(j==0){
                    cost[i][j] = 1;
                }
                else if(i==0){
                    cost[i][j] = 0;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    cost[i][j] = cost[i-1][j-1]+cost[i-1][j];
                }
                else{
                    cost[i][j] = cost[i-1][j];
                }
                System.out.print(cost[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("count for the occurrence of s2 in s1 as a sub sequence : "+cost[s1.length()][s2.length()]);
    }
}