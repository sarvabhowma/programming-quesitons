/*
n-queens, placing n queens(chess) in a n*n board
such that no queen attacks the other

Input:
4

Output:
0100
0001
1000
0010

 */
package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class n_queens{

    static class pair{
        int x,y;
        pair(int i,int j){
            this.x = i;
            this.y = j;
        }
    }

    static boolean check(int x,int y, List<pair> l){

        if(l.size()==0){
            return true;
        }

        for(pair p:l){
            if (p.y == y || Math.abs(p.x - x) == Math.abs(p.y - y)){
                return false;
            }
        }
        return true;
    }

    static boolean n_queen(int [][]a,int count,List<pair> l){
        if(a.length<=count){
            return true;
        }

        for(int i=0;i<a.length;i++){
            if(check(count,i,l)){

                a[count][i] = 1;
                pair p = new pair(count,i);
                l.add(p);

                if(n_queen(a,count+1,l)){
                    return true;
                }

                a[count][i] = 0;
                l.remove(p);
            }
        }
        return false;
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[][] = new int[n][n];
        List<pair> l = new ArrayList<>();


        if(n_queen(a,0,l)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(a[i][j]);
                }
                System.out.println();
            }
        }
        else{
            System.out.println("false");
        }

    }
}