/*
perfect hill sequence, the middle element is a peak
the left and right should have equal number count
left to peak -> increasing sequence
peak to right -> decreasing sequence

Input:
8
10 15 16 9 4 3 11 1

Output:
k : 2
2k+1 : 5
the peak element : 16

 */

package dynamic_programming;

import java.util.Scanner;

public class perfect_hill_sequence{

    static class pair{
        int x,y;
        pair(int i, int j){
            x = i;
            y = j;
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        pair inc_seq[] = new pair[n];
        pair dec_seq[] = new pair[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        // increasing sequence
        inc_seq[0] = new pair(0,-1);

        for(int i=1;i<n;i++){
            inc_seq[i] = new pair(0,-1);

            for(int j=0;j<i;j++){

                if(a[i]>a[j] && inc_seq[i].x < inc_seq[j].x + 1){
                    inc_seq[i].x = inc_seq[j].x+1;
                    inc_seq[i].y = j;
                }

            }
        }

        // decreasing sequence
        dec_seq[n-1] = new pair(0,-1);

        for(int i=n-2;i>=0;i--){
            dec_seq[i] = new pair(0,-1);

            for(int j=n-1;j>i;j--){
                if(a[j]<a[i] && dec_seq[i].x < dec_seq[j].x+1){
                    dec_seq[i].x = dec_seq[j].x+1;
                    dec_seq[i].y = j;
                }
            }
        }

        int max = 0;
        int index = -1;

        for(int i=0;i<n;i++){
            int curr = Math.min(inc_seq[i].x,dec_seq[i].x);
            if(max<curr){
                max = curr;
                index = i;
            }
        }
        System.out.println("k : "+max);
        System.out.println("2k+1 : "+(2*max+1));
        System.out.println("the peak element : "+a[index]);

    }
}

