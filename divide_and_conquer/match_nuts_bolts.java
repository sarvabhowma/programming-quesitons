/*
matching nuts and bolts

Input:
5
enter nuts : # @ $ % &
enter bolts : $ # & @ %

Output:
nuts : # $ % & @
bolts : # $ % & @
 */

package divide_and_conquer;

import java.util.Scanner;

public class match_nuts_bolts {

    static int partition(char[] a, int s, int e, char p) {
        int x = s;
        char temp;
        for (int i = s; i < e; i++) {
            if (a[i] < p) {
                temp = a[i];
                a[i] = a[x];
                a[x] = temp;
                x += 1;
            } else if (a[i] == p) {
                temp = a[i];
                a[i] = a[e];
                a[e] = temp;
                i--;
            }
        }
        temp = a[e];
        a[e] = a[x];
        a[x] = temp;

        return x;
    }

    static void matchnutsbolts(char[] nuts, char[] bolts, int s, int e) {
        int pivot;
        if (s < e) {
            // partitioning nuts based on last bolt
            pivot = partition(nuts, s, e, bolts[e]);

            // partitioning bolts based on nuts pivot
            partition(bolts, s, e, nuts[pivot]);
            matchnutsbolts(nuts, bolts, s, pivot - 1);
            matchnutsbolts(nuts, bolts, pivot + 1, e);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char nuts[] = new char[n];
        char bolts[] = new char[n];

        int s = 0, e = n - 1;
        System.out.print("enter nuts : ");
        for (int i = 0; i < n; i++) {
            nuts[i] = sc.next().charAt(0);
        }
        System.out.print("enter bolts : ");
        for (int i = 0; i < n; i++) {
            bolts[i] = sc.next().charAt(0);
        }

        matchnutsbolts(nuts, bolts, s, e);

        System.out.print("nuts : ");
        for (int i = 0; i < n; i++) {
            System.out.print(nuts[i] + " ");
        }

        System.out.println();
        System.out.print("bolts : ");
        for (int i = 0; i < n; i++) {
            System.out.print(bolts[i] + " ");
        }
    }
}