/*
finding a path for the rat to escape the maze

Input:
4
1 1 0 0
1 1 1 1
0 0 1 0
1 1 1 1

Output:
1 1 0 0
1 1 1 0
0 0 1 0
0 0 1 1

 */
package backtracking;

import java.util.Scanner;

public class rat_in_maze {

    static boolean solve_maze(int[][] maze,int x,int y,int[][] sol){
        int n = maze.length;

        if(x==n-1 && y==n-1){
            sol[x][y] = 1;
            return true;
        }
        if(x<0 || y<0 || x==n || y==n || maze[x][y]!=1){
            return false;
        }

        sol[x][y] =1;

        boolean r=solve_maze(maze,x+1,y,sol);
        boolean d=solve_maze(maze,x,y+1,sol);

        if(r||d){
            return true;
        }
        else{
            sol[x][y] = 0;
            return false;
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maze[][] = new int[n][n];
        int sol[][] = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                maze[i][j] = sc.nextInt();
            }
        }

        if(solve_maze(maze,0,0,sol)){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(sol[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}
