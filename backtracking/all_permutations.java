/*
showing all the permutations of a string

Input:
bat

Output:
bat
bta
abt
atb
tab
tba

 */
package backtracking;

import java.util.Scanner;

public class all_permutations{

    static void all_permutations(char a[], int s, int l){
        if(s==l){
            System.out.println(new String(a));
            return;
        }

        for(int i=s;i<=l;i++){
            char c = a[s];
            a[s] = a[i];
            a[i] = c;
            all_permutations(a,s+1,l);
            a[i] = a[s];
            a[s] = c;
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        char a[] = sc.nextLine().toCharArray();

        all_permutations(a,0,a.length-1);
    }
}
