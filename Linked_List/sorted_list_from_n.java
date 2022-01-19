/*
merging n sorted lists

Input:
Enter the no of lists : 5
enter the size of the current list : 5
1 4 7 9 81
enter the size of the current list : 4
12 35 47 50
enter the size of the current list : 5
2 8 57 64 76
enter the size of the current list : 3
3 54 63
enter the size of the current list : 6
6 24 36 49 60 77

Output:
1 2 3 4 6 7 8 9 12 24 35 36 47 49 50 54 57 60 63 64 76 77 81

 */

package Linked_List;

import java.util.*;

public class sorted_list_from_n {

    static class node{
        int value;
        node next;
    }

    public static node merge(node l1,node l2){
        node merge;
        if(l1.value<l2.value){
            merge = l1;
            l1 = l1.next;
        }
        else {
            merge = l2;
            l2 = l2.next;
        }

        node temp = merge;

        while(l1!=null && l2!=null){
            if(l1.value<l2.value){
                temp.next = l1;
                l1 = l1.next;
            }
            else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if(l1!=null){
            temp.next = l1;
        }
        else
            temp.next = l2;

        return merge;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no of lists : ");
        int n = sc.nextInt();
        node l[] = new node[n];
        for(int i=0;i<n;i++){
            System.out.print("enter the size of the current list : ");
            int m = sc.nextInt();
            l[i] = new node();
            l[i].value = sc.nextInt();
            l[i].next = null;
            node iter = l[i];
            for(int j=1;j<m;j++){
                node temp = new node();
                temp.value = sc.nextInt();
                temp.next = null;
                iter.next = temp;
                iter = iter.next;
            }
        }

//        for(int i = 0;i<n;i++){
//            node temp = l[i];
//            while(temp!=null){
//                System.out.print(temp.value+" ");
//                temp = temp.next;
//            }
//            System.out.println();
//        }


        for(int i = 1;i<n;i++){
            l[i] = merge(l[i-1],l[i]);
        }

        while(l[n-1]!=null){
            System.out.print(l[n-1].value+" ");
            l[n-1] = l[n-1].next;
        }
    }
}
