/*
check whether given list is palindrome or not

Input:
7
1 2 3 4 3 2 1

Output:
Palindrome

Input:
5
1 2 3 4 5

Output:
Not Palindrome

 */

package Linked_List;

import java.util.*;

public class palindrome {
    static class node {
        int value ;
        node next;
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        node head = new node();
        head.value = sc.nextInt();
        node l = head;
        for(int i=1;i<n;i++){
            node temp = new node();
            temp.value = sc.nextInt();
            temp.next = null;
            l.next = temp;
            l = l.next;
        }
        int len = 0;
        l = head;
        while(l!=null){
            l = l.next;
            len++;
        }

        double mid= Math.ceil(len/2);
        node half=head;
        while(mid -- >=0){
            half = half.next;
        }

        node prev=null;
        node next=null;
        while(half!=null){
            next = half.next;
            half.next=prev;
            prev = half;
            half = next;

        }
        half = prev;
        mid= Math.ceil(len/2);
        int i = 0;

        for(i=0;i<mid;i++){
            if(head.value!=half.value)
                break;
        }
        if(i!=mid)
            System.out.println("Not Palindrome");
        else
            System.out.println("Palindrome");


    }
}
