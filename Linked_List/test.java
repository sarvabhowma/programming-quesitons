package Linked_List;

import java.util.*;

public class test {

    static class node {
        int value;
        node next;
    }

    static node merge_sort(node head, int n) {
        node l1 = new node(), l2 = new node();
        int m = Math.floorDiv(n, 2);
        int k = 0;

        if(n%2==0)
            k = (int) Math.ceil(n / 2);
        else
            k = (int) Math.ceil(n / 2)+1;

        if (n <= 1)
            return head;

        node l = l2;
        node l3= l1;

        l1.value = head.value;

        for (int i = 0; i < n; i++) {

            if(i < Math.floorDiv(n,2)) {
                node temp = new node();
                temp.value = head.value;
                temp.next = null;
                l3.next = temp;
                l3 = l3.next;

            }
            else if(i == Math.floorDiv(n,2)) {
                l.value = head.value;
            }

            else{
                node temp = new node();
                temp.value = head.value;
                temp.next = null;
                l.next = temp;
                l = l.next;

            }
            head = head.next;
        }

        l1 = merge_sort(l1, Math.floorDiv(n, 2));
        l2 = merge_sort(l2, (int) Math.ceil(n / 2));

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
        return sorted_list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the size of the list : ");
        int n = sc.nextInt();
        node head = new node();
        node temp = head;
        for (int i = 0; i < n - 1; i++) {
            temp.value = sc.nextInt();
            temp.next = new node();
            temp = temp.next;
        }
        temp.value = sc.nextInt();
        temp.next = null;

        temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();

        head = merge_sort(head, n);

        temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }

    }
}
