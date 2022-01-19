/*
merge sort for the given linked list

Input:
enter the size of the list : 9
32 4 54 43 76 23 87 9 63

Output:
4 9 23 32 43 54 63 76 87

 */

package Linked_List;

import java.util.*;

public class merge_sort {

    static class node {
        int value;
        node next;
    }

    static node merge_sort(node head1, int n) {
        node left, right,head = new node();
        int m = Math.floorDiv(n, 2);
        int k = 0;

        if (n <= 1)
            return head1;

        head.value = head1.value;
        head1 = head1.next;

        if (n % 2 == 0)
            k = (int) Math.ceil(n / 2);
        else
            k = (int) Math.ceil(n / 2) + 1;

        node l = head;
        for(int i=1;i<n;i++){
            node temp = new node();
            temp.value = head1.value;
            temp.next = null;
            l.next = temp;
            l = l.next;
            head1 = head1.next;

        }
        left = head;
        right = head;

        for (int i = 0; i < Math.floorDiv(n, 2); i++)
            right = right.next;

        left = merge_sort(left, m);
        right = merge_sort(right, k);

        node sort;
        if(left.value<right.value){
            sort = left;
            left = left.next;
            m--;
        }
        else{
            sort = right;
            right = right.next;
            k--;
        }
        node temp = sort;

        while(m!=0 && k!=0){
            if(left.value < right.value){
                temp.next = left;
                left = left.next;
                m--;
            }
            else{
                temp.next = right;
                right = right.next;
                k--;
            }
            temp = temp.next;
        }

        if(m!=0){
            while(m!=0){
                temp.next = left;
                left = left.next;
                m--;
                temp = temp.next;
            }
        }
        else{
            while(k!=0){
                temp.next = right;
                right = right.next;
                k--;
                temp = temp.next;
            }
        }
        temp.next = null;

        return sort;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the size of the list : ");
        int n = sc.nextInt();
        node head = new node();
        head.value = sc.nextInt();
        node temp = head;
        for (int i = 1; i < n; i++) {
            node l = new node();
            l.value = sc.nextInt();
            l.next = null;
            temp.next = l;
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
