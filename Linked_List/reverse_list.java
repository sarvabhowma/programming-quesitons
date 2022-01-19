/*
reverse list and print

Input:
5 //size of the list
1 2 3 4 5

Output:
->5->4->3->2->1

 */

package Linked_List;

import java.util.*;

public class reverse_list {

    static class node {
        int value;
        node next;
    }

    static node reverse(node head) {

        node next = null;
        node prev = null;
        prev = head;
        head = head.next;
        prev.next = null;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;

        }

        return prev;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        node l = new node();

        l.value = sc.nextInt();
        l.next = null;

        node head = l;

        for (int i = 1; i < n; i++) {

            node l1 = new node();
            l1.value = sc.nextInt();
            l1.next = null;
            l.next = l1;
            l = l.next;
        }

        head = reverse(head);
        System.out.println();

        while(head!=null){
            System.out.print("->"+head.value);
            head = head.next;
        }

    }

}

