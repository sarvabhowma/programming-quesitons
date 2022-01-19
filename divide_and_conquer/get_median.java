package divide_and_conquer;

import java.util.Scanner;

public class get_median{

    static int getmedian(int[] a, int[] b, int l1, int r1, int l2, int r2){

        int size = (r1-l1+1);

        if(size==1){
            return (a[0]+b[0])/2;
        }
        if(size==2){
            return (Math.max(a[0],b[0])+Math.min(a[1],b[1]))/2;
        }

        int mid1,mid2;
        int n1 = (r1+l1)/2;
        int n2 = (r2+l2)/2;

        if((size)%2==0){
            mid1 = (a[n1+1]+a[n1])/2;
            mid2 = (b[n2+1]+b[n2])/2;
        }
        else{
            mid1 = a[n1+1];
            mid2 = b[n2+1];
        }
        if(mid1==mid2){
            return mid1;
        }
        if(mid1<mid2){
            if(size%2==0){
                return getmedian(a,b,l1+size/2-1,r1,l2,r2-n2+1);
            }
            else{
                return getmedian(a,b,l1+size/2,r1,l2,r2-size/2);
            }
        }
        else{
            if(size%2==0){
                return getmedian(b,a,l2+size/2-1,r2,l1,r1-size/2+1);
            }
            else{
                return getmedian(b,a,l2+size/2,r2, l1, r1-size/2);
            }
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            b[i] = sc.nextInt();
        }

        System.out.println(getmedian(a,b,0,n-1,0,n-1));
    }
}
