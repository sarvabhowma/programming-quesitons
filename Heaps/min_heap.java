/*
heap sort in ascending order using min heap program

Input :
enter the size of the heap :
9
5 3 17 10 84 19 6 22 9

Output :
3, 5, 6, 9, 10, 17, 19, 22, 84,

 */

package Heaps;

import java.util.Scanner;

public class min_heap {

    static int a[];
    static int n;

    static void build_heap() {

        int index = 0;

        while (2 * index+2 < n ) {
            if (a[index] > a[2 * index + 1] || a[index] > a[2 * index + 2]) {
                if (a[2 * index + 2] > a[2 * index + 1]) {
                    int x = a[2 * index + 1];
                    a[2 * index + 1] = a[index];
                    a[index] = x;
                    index = 2 * index + 1;
                } else {
                    int x = a[2 * index + 2];
                    a[2 * index + 2] = a[index];
                    a[index] = x;
                    index = 2 * index + 2;
                }
            } else {
                break;
            }
        }
        if(2 * index+1 < n){
            if(a[index] > a[2 * index + 1]) {
                int x = a[2 * index + 1];
                a[2 * index + 1] = a[index];
                a[index] = x;
            }
        }
    }

    static void insert(int k, int index) {

        a[index] = k;

        while (a[index] < a[(index-1) / 2]) {
            int x = a[(index-1) / 2];
            a[(index-1) / 2] = a[index];
            a[index] = x;
            index = (index-1)/2;
        }
    }

    static int delete() {
        int k = a[0];
//        k = a[0];
        a[0] = a[--n];
        build_heap();
        return k;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the heap : ");
        n = sc.nextInt();
        a = new int[n];
        a[0] = -1;

        for (int i = 0; i < n; i++) {
            insert(sc.nextInt(), i);
        }

        for (int i = 0; i < a.length; i++) {
            int k = delete();
            System.out.print(k + ", ");
        }

    }
}
