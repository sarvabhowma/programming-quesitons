/*
Given an array & an integer k, find the maximum
element for each and every contiguous sub array of size.

Input:
7
10 9 8 1 2 3 6
3

Output:
10 9 8 3 6

 */


package Arrays_0;
import java.util.*;


public class sub_array_maximums {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int []a=new int[n];
        ArrayList<Integer> l = new ArrayList();
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        int k=sc.nextInt();
        l.add(0);
        for(int i=1;i<k;i++){
            int j=l.size()-1;
            while(j>=0){
                if(a[i]>a[l.get(j)])
                    l.remove(new Integer(l.get(j)));
                else{
                    l.add(i);
                    break;
                }
                j--;
            }
            if(l.size()==0)
                l.add(i);
        }
        System.out.print(a[l.get(0)]+" ");
        for(int i=k;i<n;i++){
            l.remove(new Integer(i-k));
            int j=l.size()-1;
            while(j>=0){
                if(a[i]>a[l.get(j)])
                    l.remove(new Integer(l.get(j)));
                else{
                    l.add(i);
                    break;
//                    l.stream().sorted(l);
                }
                j--;
            }
            if(l.size()==0)
                l.add(i);
            System.out.print(a[l.get(0)]+" ");
        }


    }

}


