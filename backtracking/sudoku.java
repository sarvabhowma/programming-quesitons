/*
Testcases:
0 3 0 0 0 0 6 5 0
0 5 6 0 4 0 7 0 0
4 2 0 0 0 0 3 8 0
0 6 0 0 0 0 8 0 0
0 0 9 0 2 0 0 7 0
1 0 0 8 0 0 2 0 6
0 0 5 7 0 0 0 0 1
0 0 0 2 0 0 0 3 0
0 0 7 0 5 6 0 2 0

0 3 8 9 0 2 6 5 0
9 0 6 3 4 0 0 1 2
4 2 0 0 6 7 3 0 9
0 6 2 1 0 4 8 9 0
8 0 9 6 2 0 0 7 5
1 7 0 0 9 5 2 0 6
0 8 5 7 0 9 4 6 0
3 1 0 0 5 6 9 0 8

0 3 8 0 1 2 0 5 4
9 0 6 0 4 8 7 0 2
4 0 1 5 0 7 3 0 9
0 6 2 0 7 4 0 9 3
8 4 0 6 2 0 1 7 0
1 0 3 8 9 0 0 4 6
2 8 0 7 0 9 0 6 1
0 9 4 2 0 1 5 3 0
3 1 0 4 0 6 9 0 8

Output:
7 3 8 9 1 2 6 5 4
9 5 6 3 4 8 7 1 2
4 2 1 5 6 7 3 8 9
5 6 2 1 7 4 8 9 3
8 4 9 6 2 3 1 7 5
1 7 3 8 9 5 2 4 6
2 8 5 7 3 9 4 6 1
6 9 4 2 8 1 5 3 7
3 1 7 4 5 6 9 2 8

 */

package backtracking;

import java.util.Scanner;

public class sudoku {

    static int check(int[][] s,int x, int y, int k){

        int n=(x/3)*3;
        int m=(y/3)*3;

        for(int i=n;i<n+3;i++){
            for(int j=m;j<m+3;j++){

                if(s[i][j]==k){
                    return 1;
                }

            }
        }

        return 0;
    }

    static int validation(int[][] s,int x, int y, int k){

        // checking in the 3*3 matrix
        int flag = check(s,x,y,k);

        // checking in the same row
        for(int j=0;j<9;j++){
            if(s[x][j]==k){
                return 1;
            }
        }

        // checking in the same column
        for(int j=0;j<9;j++){
            if(s[j][y]==k){
                return 1;
            }
        }
        return flag;
    }

    static boolean solve_sudoku(int[][] s,int x,int y){
        if(x<0 || y<0 || x>=9 || y>=9){
            return false;
        }
        if(s[x][y]!=0){
            return false;
        }

        int flag=0;
        boolean p,q,r,t;

        for(int i=1;i<=9;i++){

            flag = validation(s,x,y,i);

            if(flag==0){
                s[x][y] = i;
                p = solve_sudoku(s,x-1,y);
                q = solve_sudoku(s,x,y-1);
                r = solve_sudoku(s,x+1,y);
                t = solve_sudoku(s,x,y+1);

                if(p||q||r||t){
                    return true;
                }
                else{
                    int f=0,m=-1,n=-1;
                    // checking if any non filled place
                    for(int j=0;j<9;j++){
                        for(int k=0;k<9;k++){
                            if(s[j][k]==0){
                                m=j;
                                n=k;
                                break;
                            }
                        }
                    }

                    if((m==-1) || solve_sudoku(s,m,n)){
                        return true;
                    }
                    s[x][y] = 0;
                }

            }

            flag = 0;
        }

        return false;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int s[][] = new int[9][9];

        System.out.println("enter the values in a sudoku : ");
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                s[i][j] = sc.nextInt();
            }
        }
        solve_sudoku(s,0,0);

        System.out.println();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(s[i][j]+" ");
            }
            System.out.println();
        }
    }
}
