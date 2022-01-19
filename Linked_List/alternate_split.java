/*
alternating split of the list

Input:
5 // size of the list
1 2 3 4 5

Output:
1,3,5, // first list
2,4, // sec list

 */

package Linked_List;

import java.util.*;

public class alternate_split {

    static class node {
        int value;
        node next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        node head = new node();
        head.value = sc.nextInt();
        node l = head;

        for (int i = 1; i < n; i++) {
            node temp = new node();
            temp.value = sc.nextInt();
            temp.next = null;
            l.next = temp;
            l = l.next;
        }

        node head2 = head.next;
        node head1 = head;

        while (head.next != null) {
            node temp = head.next;
            head.next = head.next.next;
            head = temp;
        }

        while (head1 != null) {
            System.out.print(head1.value + ",");
            head1 = head1.next;
        }

        System.out.println();

        while (head2 != null) {
            System.out.print(head2.value + ",");
            head2 = head2.next;
        }

    }

}

