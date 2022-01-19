package Hashing;

import java.util.*;

public class test {

    static class node{
        int k;
        int i;
        node(int x, int y){
            this.k = x;
            this.i = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        PriorityQueue<node> mh = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            node l = new node(sc.nextInt(),i);
            mh.add(l);
        }

        for(int i=0;i<n;i++){
            node x = mh.remove();
            System.out.print(x.k+" "+x.i+", ");
        }
    }
}
