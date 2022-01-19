/*
check whether the list has a loop or not ?
1 -- yes
0 -- no

Input:
5 //size of the list
10 20 30 40 50

Output:
1

 */

package Linked_List;

import java.util.*;

public class detect_loop {

    static class node {
        int value;
        node next;
    }

    static int loop(node head) {
        node fast_ptr = head;
        node slow_ptr= head;
        int x = 0;

        while ((fast_ptr != null) && (fast_ptr.next != null)) {

            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;

            if(fast_ptr.value == slow_ptr.value){
                x++;
                break;
            }
        }
         return x;
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

        head.next.next.next.next = head.next.next;// creating loop or comment this statement for not creating loop

        System.out.println(loop(head));

    }

}
