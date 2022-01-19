package divide_and_conquer;

// shuffle array

import java.util.Scanner;

public class test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int mid = (0 + n - 1) / 2;
        int temp = mid + 1;

        for (int i = 1; i <= mid; i++) {
            temp = mid + 1;
            for (int j = i; j <= mid; j++) {
                int k = a[j];
                a[j] = a[temp];
                a[temp] = k;
                temp++;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}