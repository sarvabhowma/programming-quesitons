package Arrays_0;

import java.util.Scanner;

public class test{

    static int jump(int i,int[] a){

        if(i+a[i]>=a.length-1){
            return 1;
        }
        else{
            for(int j=1;j<=a[i];j++){
                int k = jump(i+j,a);
                if(k==1){
                    return 1;
                }
            }
        }

        return 0;
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        int flag = jump(0,a);

        if(flag==0){
            System.out.println("false");
        }
        else{
            System.out.println("true");
        }

//        System.out.println(canjump(a));
    }
}