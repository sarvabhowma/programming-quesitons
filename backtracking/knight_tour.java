/*
knights tour -> checking all possible moves a knight(chess)
can go in a n*n board

Input:
3
Output:
1 1 1
1 0 1
1 1 1

 */
package backtracking;

import java.util.Scanner;

public class knight_tour {

    static void knight_tour(int moves[][],int x, int y){
        int n = moves.length;
        if(x<0 || y<0 || x>=n || y>=n){
            return;
        }
        if(moves[x][y]==1){
            return;
        }
        moves[x][y]=1;

        knight_tour(moves,x-2,y-1);
        knight_tour(moves,x-2,y+1);
        knight_tour(moves,x+2,y-1);
        knight_tour(moves,x+2,y+1);
        knight_tour(moves,x-1,y-2);
        knight_tour(moves,x+1,y-2);
        knight_tour(moves,x-1,y+2);
        knight_tour(moves,x+1,y+2);

        return;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int moves[][] = new int[n][n];

        knight_tour(moves,0,0);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(moves[i][j]+" ");
            }
            System.out.println();
        }
    }
}
