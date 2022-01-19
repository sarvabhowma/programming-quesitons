/*
merging two sorted lists

Input:
5 // length of the first list
1 3 5 7 8

5 // length of the sec list
2 4 6 9 10

Output:
1 2 3 4 5 6 7 8 9 10

 */


package Linked_List;

import java.util.*;

public class sorted_list_from_2 {

    static class node {
        int value;
        node next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        node l1 = new node();
        l1.value = sc.nextInt();
        node l = l1;
        for (int i = 1; i < m; i++) {
            node temp = new node();
            temp.value = sc.nextInt();
            temp.next = null;
            l.next = temp;
            l = l.next;
        }

        System.out.println();
        int n = sc.nextInt();
        node l2 = new node();
        l2.value = sc.nextInt();
        l = l2;
        for (int i = 1; i < n; i++) {
            node temp = new node();
            temp.value = sc.nextInt();
            temp.next = null;
            l.next = temp;
            l = l.next;
        }

        node sorted_list ;

        if (l1.value < l2.value) {
            sorted_list = l1;
            l1 = l1.next;
        } else {
            sorted_list = l2;
            l2 = l2.next;
        }

        node temp = sorted_list;

        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(l1!=null)
            temp.next = l1;
        else
            temp.next = l2;

        while(sorted_list!=null) {
            System.out.print(sorted_list.value + " ");
            sorted_list = sorted_list.next;
        }
    }
}
