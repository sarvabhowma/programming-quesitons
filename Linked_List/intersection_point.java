/*
finding the intersection point of 2 lists

Input:
9 // size of first list
2 // size of sec list
1 2 3 4 5 6 7 8 9 // first list
10 20 // sec list

Output:
sec list after merging is : 10,20,4,5,6,7,8,9,
4 // intersection point

 */

package Linked_List;

import java.util.*;

public class intersection_point {

    static class node {
        int value;
        node next;
    }

    public static int length(node h) {
        int l = 0;
        while (h != null) {
            h = h.next;
            l++;
        }
        return l;
    }

    public static int intersection_point1(node head1, node head2) {
        int p = length(head1);
        int q = length(head2);
        node h1;
        node h2;
        if (p > q) {
            h1 = head1;
            h2 = head2;
        } else {
            h1 = head2;
            h2 = head1;
        }
        int n = Math.abs(p - q);
        for (int i = 0; i < n; i++) {
            h1 = h1.next;
        }
        while (h1.value != h2.value) {
            h1 = h1.next;
            h2 = h2.next;
        }
        return h1.value;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        node head1 = new node();
        head1.value = sc.nextInt();
        node l = head1;


        for (int i = 1; i < m; i++) {
            node temp = new node();
            temp.value = sc.nextInt();
            temp.next = null;
            l.next = temp;
            l = l.next;
        }

        node head2 = new node();
        head2.value = sc.nextInt();
        l = head2;
        for (int i = 1; i < n; i++) {
            node temp = new node();
            temp.value = sc.nextInt();
            temp.next = null;
            l.next = temp;
            l = l.next;
        }
        l.next = head1.next.next.next;
        System.out.print("sec list after merging is : ");

        l = head2;
        while (l != null) {
            System.out.print(l.value+",");
            l = l.next;
        }

        System.out.println("\n"+intersection_point1(head1, head2));


    }

}
