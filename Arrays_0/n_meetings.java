/*
There is one meeting room in a firm. There are N meetings
in the form of (start[i], end[i]) where start[i] is
start time of meeting i and end[i] is finish time of meeting i.
What is the maximum number of meetings that can be
accommodated in the meeting room when only one meeting
can be held in the meeting room at a particular time?

Note: Start time of one chosen meeting can't be equal
to the end time of the other chosen meeting.

Input:
6
1 3 0 5 8 5
2 4 6 7 9 9

Output:
4

 */

package Arrays_0;

import java.util.*;

public class n_meetings {

    public static int maxMeetings(int start[], int end[], int n)
    {

        int a[][] = new int[n][2];

        for(int i=0;i<n;i++){
            a[i][0] = start[i];
            a[i][1] = end[i];
        }

        Arrays.sort(a,Comparator.comparingInt(o->o[1]));

        int p = a[0][1];
        int j = 1;
        int count = 0;

        while(j<n){
            if(a[j][0]<=p){
                count++;
                p = Math.min(p,a[j][1]);
            }
            else{
                p = a[j][1];
            }
            j++;
        }

        return n-count;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start[] = new int[n];
        int end[] = new int[n];
        for(int i=0;i<n;i++){
            start[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            end[i] = sc.nextInt();
        }
        System.out.println(maxMeetings(start,end,n));
    }
}
