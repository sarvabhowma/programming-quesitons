/*
Find the kth node from the end

Input:
5 //size of the list
1 2 3 4 5
2 //k value

Output:
4

 */

package Linked_List;

import java.util.*;

public class kth_node_from_end {

    static class node {
        int value;
        node next;
    }

    static int kth_node(node head, int k) {
        node sec = head;

        for (int i = 0; i < k; i++)
            head = head.next;

        while (head != null) {
            sec = sec.next;
            head = head.next;
        }
        return sec.value;
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

        int k = sc.nextInt();
        int x = kth_node(head, k);

        System.out.println(x);

    }

}
