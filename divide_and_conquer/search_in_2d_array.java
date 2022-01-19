/*
searching an element in the 2d array using divide and conquer
method
the array is sorted in row wise and column wise
Input:
4
4
10 20 30 40
15 25 35 45
27 29 37 48
32 33 39 50
29

Output:
true

 */

package divide_and_conquer;

import java.util.Scanner;

public class search_in_2d_array{

    static boolean search(int[][] a,int k, int l1, int r1, int l2, int r2){
        if(l1==r1 && l2==r2){
            if(a[l1][l2]==k){
                return true;
            }
            return false;
        }
        else if(l1>r1 || l2>r2){
            return false;
        }

        int mid1 = (l1+r1)/2;
        int mid2 = (l2+r2)/2;
        boolean x,y,z;
        if(a[mid1][mid2] == k){
            return true;
        }
        else if(a[mid1][mid2]>k){
            x = search(a,k,l1,mid1,l2,mid2);
            y = search(a,k,mid1+1,r1,l2,mid2);
            z = search(a,k,l1,mid1,mid2+1,r2);
        }
        else{
            x = search(a,k,l1,mid1,mid2+1,r2);
            y = search(a,k,mid1+1,r1,l2,mid2);
            z = search(a,k,mid1+1,r1,mid2+1,r2);
        }
        return (x||y||z);
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int a[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j]=sc.nextInt();
            }
        }
        int k = sc.nextInt();

        System.out.println(search(a,k,0,n-1,0,m-1));
    }
}
