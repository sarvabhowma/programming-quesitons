/*
largest element in the right side
the rand pointer points to the largest node in the right side

Input:
5
1 32 5 23 7

Output:
( 1, 32 ) ( 32, 23 ) ( 5, 23 ) ( 23, 7 ) ( 7, 0 )

 */

package Linked_List;

import java.util.*;

public class biggest_right_element {

    static class node {
        int value;
        node rand;
        node next;
    }

    static node reverse(node head) {
        node next = null, prev = null;

        while (head != null) {

            next = head.next;
            head.next = prev;
            prev = head;
            head = next;

        }
        return prev;
    }

    static node next_largest(node head) {

        head = reverse(head);

        node max = new node();
        node l = head;
        head.rand=new node();
        max = l;
        l = l.next;

        while(l!=null){
            l.rand = max;
            if(l.value>=max.value){
                max = l;
            }
            l = l.next;
        }

        head = reverse(head);

        return head;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        node head = new node();
        head.value = sc.nextInt();
        head.rand = null;
        head.next = null;

        node l = head;
        for (int i = 1; i < n; i++) {
            node temp = new node();
            temp.value = sc.nextInt();
            temp.rand = null;
            temp.next = null;
            l.next = temp;
            l = l.next;
        }

        head = next_largest(head);

        while(head!=null){
            System.out.print("( "+head.value+", "+head.rand.value+" )"+" ");
            head=head.next;
        }
    }
}
