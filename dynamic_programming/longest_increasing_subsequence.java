/*
longest increasing subsequence in an array

Input:
7
2 3 1 5 12 10 11

Output:
5 // size of the sequence
2 3 5 10 11  // sequence
 */

package dynamic_programming;

import java.util.Scanner;

public class longest_increasing_subsequence{

    static class pair{
        int x=0,y=0;
        pair(int i,int j){
            x = i;
            y = j;
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int l[] = new int[n];
        l[0] = 1;
        int max = 0;

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(a[j]<a[i] && l[i]<l[j]+1)
                    l[i] = l[j]+1;
            }
            if(max<l[i]){
                max = l[i];
            }
        }
        System.out.println(max);

        // different approach for getting the sequence
        pair p[] = new pair[n];
        p[n-1] = new pair(1,-1);

        max = 0;
        int index = 0;
        for(int i=n-2;i>=0;i--){
            p[i] = new pair(0,-1);
            for(int j=n-1;j>i;j--){
                if(a[j]>a[i] && p[i].x<p[j].x+1){
                    p[i].x = p[j].x+1;
                    p[i].y = j;
                }
            }
            if(max<p[i].x){
                max = p[i].x;
                index = i;
            }
        }

        while(index!=-1){
            System.out.print(a[index]+" ");
            index = p[index].y;
        }

    }
}