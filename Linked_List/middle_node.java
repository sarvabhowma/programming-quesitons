/*
Find the middle node value in the list

Input:
3 //size of the list
1 2 3

Output:
2

 */

package Linked_List;

import java.util.*;

public class middle_node {

    static class node {
        int value;
        node next;
    }

    static int middle(node head) {
        node fast_ptr = head;
        node slow_ptr = head;

        while ((fast_ptr != null) && (fast_ptr.next != null)) {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }

        return slow_ptr.value;
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

        int x = middle(head);
        System.out.println(x);

    }

}


