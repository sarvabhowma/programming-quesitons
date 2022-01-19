/*
adding one to decimal number represented in list

Input:
5
9 8 7 9 9 (98799)

Output:
9 8 8 0 0 (98799 + 1 = 98800)

 */

package Linked_List;

import java.util.*;

public class adding_one {

    static class node{
        int value;
        node next;
    }

    static node reverse(node head){
        node next = null;
        node prev = null;

        while(head!=null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        node head = new node();
        head.value = sc.nextInt();
        head.next = null;
        node l = head;
        for(int i=1;i<n;i++){
            node temp = new node();
            temp.value = sc.nextInt();
            temp.next = null;
            l.next = temp;
            l = l.next;
        }

        head = reverse(head);
        l = head;
        int c = 1;

        while(l.next!=null){
            int value = l.value + c;
            l.value = value%10;
            c = value/10;
            l = l.next;
        }
        int value = l.value + c;
        l.value = value%10;
        c = value/10;

        if(c==1){
            l.next = new node();
            l = l.next;
            l.value = c;
        }
        l.next = null;


        head = reverse(head);

        while(head!=null){
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
