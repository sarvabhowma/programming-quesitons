/*
code for largest multiple of 3.

Input:
10
6 5 4 3 2 2 1 9 8 7

Output:
987654321

 */

package Arrays_0;
import java.util.*;


public class Largest_No_Divisible_By_Three {

    static ArrayList<Integer> rem_remainder(ArrayList<Integer> l, int x){

        for(int i=0;i<l.size();i++)
            if(l.get(i)%3==x){
                l.remove(new Integer(l.get(i)));
                break;
            }

        return l;

    }

    static void remainder(ArrayList<Integer> l, int x){
        int y;
        ArrayList<Integer> l1,l2;
        if(x==1)
            y=2;
        else
            y=1;
        l1 = rem_remainder(l,x);
        int s = l1.stream().mapToInt(Integer::intValue).sum();
        if(s%3==0)
            number(l1);
        else{
            l1 = rem_remainder(l,y);
            l2 = rem_remainder(l1,y);
            s = l2.stream().mapToInt(Integer::intValue).sum();
            if(s%3==0)
                number(l2);
            else
                System.out.println("NO");
        }
    }

    static void number(ArrayList<Integer> l){

        for(int i=l.size()-1;i>=0;i--)
            System.out.print(l.get(i));
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> l = new ArrayList();

        for(int i=0;i<n;i++)
            l.add(sc.nextInt());
        Collections.sort(l);
        int sum = l.stream().mapToInt(Integer::intValue).sum();
        if(sum%3==0)
            number(l);
        else{
            remainder(l,sum%3);
        }
    }

}



