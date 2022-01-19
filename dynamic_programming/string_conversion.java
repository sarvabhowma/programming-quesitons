/*
converting string-2 to string-1 using
1. replace
2. insert
3. delete
with minimum number of operations possible

Input:
rabbit
barrow

Output:
0 1 2 3 4 5 6
1 1 2 2 3 4 5
2 2 1 2 3 4 5
3 2 2 2 3 4 5
4 3 3 3 3 4 5
5 4 4 4 4 4 5
6 5 5 5 5 5 5
5

 */
package dynamic_programming;

import java.util.Scanner;

public class string_conversion{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int a[][] = new int[s1.length()+1][s2.length()+1];

        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                if(i==0){
                    a[i][j] = j;
                }
                else if(j==0){
                    a[i][j] = i;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    a[i][j] = a[i-1][j-1];
                }
                else{
                    a[i][j] = 1 + Math.min(Math.min(a[i-1][j],a[i][j-1]),a[i-1][j-1]);
                }
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(a[s1.length()][s2.length()]);
    }
}


