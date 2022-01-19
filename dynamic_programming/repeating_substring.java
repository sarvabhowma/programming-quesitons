/*
longest non-overlapping repeating substring

Input:
stringaldkjflaksdsatstring

Output:
substring length : 6
string

 */
package dynamic_programming;

import java.util.Scanner;

public class repeating_substring{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        int a[][] = new int[n][n];

        int max = 0, index = -1;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j) && i==0 ){
                    a[i][j] = 1;
                }
                else if(s.charAt(i)==s.charAt(j)){
                    a[i][j] = 1+a[i-1][j-1];
                }
                if(max<a[i][j]){
                    max = a[i][j];
                    index = i;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("substring length : "+max);
        System.out.println(s.substring(index-max+1,index+1));
    }
}