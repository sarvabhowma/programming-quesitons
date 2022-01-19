/*
minimum cost identical strings with only deletion operation
p = deletion cost of s1;
q = deletion cost of s2;
minimum deletion cost required to make two strings
identical

Input:
string
straight
deletion cost of s1 : 1
deletion cost of s2 : 2

Output:
0 1 2 3 4 5 6 7 8
1 0 2 4 5 6 7 8 9
2 1 0 2 4 6 8 9 8
3 2 1 0 2 4 6 8 9
4 3 2 1 3 2 4 6 8
5 4 3 2 4 3 5 7 9
6 5 4 3 5 4 3 5 7
7

 */
package dynamic_programming;

import java.util.Scanner;

public class min_cost_identical_string{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.print("deletion cost of s1 : ");
        int p = sc.nextInt();
        System.out.print("deletion cost of s2 : ");
        int q = sc.nextInt();
        int cost[][] = new int[s1.length()+1][s2.length()+1];

        for(int i=0;i<s1.length()+1;i++){
            for(int j=0;j<s2.length()+1;j++){
                if(i==0){
                    cost[i][j] = j;
                }
                else if(j==0){
                    cost[i][j] = i;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    cost[i][j] = cost[i-1][j-1];
                }
                else{
                    cost[i][j] = Math.min(cost[i-1][j]+p,cost[i][j-1]+q);
                }
                System.out.print(cost[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(cost[s1.length()][s2.length()]);
    }
}