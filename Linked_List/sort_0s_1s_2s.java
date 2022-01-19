/*
sorting a list of 0s, 1s and 2s

Input:
5
2 2 1 0 0

Output:
0 0 1 2 2

 */

package Linked_List;

import java.util.*;

public class sort_0s_1s_2s {

    static class node{
        int value;
        node next;
    }

    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        node head =  new node();
        head.value = sc.nextInt();
        head.next = null;
        node l = head;
        for(int i=1;i<n;i++){
            node temp = new node ();
            temp.value = sc.nextInt();
            temp.next = null;
            l.next = temp;
            l = l.next;
        }
        node end =l;

        node start = head;

        while(head.value==2){
            start = head.next;
            head.next = null;
            end.next = head;
            end = end.next;
            head = start;
            n--;
        }

        node prev = head;
        head = head.next;

        while(n-->0){

            if(head.value == 0){
                prev.next = head.next;
                head.next = start;
                start = head;
                head = prev.next;

            }
            else if(head.value == 2){
                prev.next = head.next;
                head.next = null;
                end.next = head;
                end = end.next;
                head = prev.next;
            }
            else {

                prev = head;
                head = head.next;

            }
        }

        while(start!=null){
            System.out.print(start.value + " ");
            start = start.next;
        }

    }
}
