/*
job scheduling for getting max profit
job -> start time, end time, profit

Input:
4
1 4 100
3 4 50
3 6 300
1 2 20

Output:
maximum profit : 320

 */
package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

public class job_scheduling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int jobs[][] = new int[n][3];
        int max_profit[] = new int[n];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = sc.nextInt();
            jobs[i][1] = sc.nextInt();
            jobs[i][2] = sc.nextInt();
        }

        Arrays.sort(jobs, (a, b) -> Double.compare(a[1], b[1]));
        max_profit[0] = jobs[0][2];

        for (int i = 1; i < n; i++) {
            int k = jobs[i][2];
            int j = i - 1;

            while (j>=0 && jobs[j][1] > jobs[i][0]) {
                j--;
            }

            if (j >= 0) {
                k += max_profit[j];
            }
            max_profit[i] = Math.max(max_profit[i - 1], k);
        }
        System.out.println("maximum profit : " + max_profit[n - 1]);

    }
}