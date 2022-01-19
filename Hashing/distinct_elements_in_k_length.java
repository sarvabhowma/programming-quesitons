/*
counting the distinct elements in k length window in the given array

Input:
5 // array size
1 1 1 1 1
3 // window size

output:
0 0 0

Input:
5 // array size
1 2 3 4 5
3 // window size

output:
3 3 3

 */

package Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class distinct_elements_in_k_length {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        int a[] = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int k = sc.nextInt();
        int count = 0;

        for (int i = 0; i < k; i++) {
            if (map.containsKey(a[i])) {
                if (map.get(a[i]) == 1) {
                    count -= 1;
                }
                map.replace(a[i], map.get(a[i]) + 1);
            } else {
                map.put(a[i], 1);
                count += 1;
            }
        }

        System.out.print(count + " ");

        for (int i = k; i < n; i++) {
            if (map.containsKey(a[i])) {
                if (map.get(a[i]) == 1) {
                    count -= 1;
                }
                map.replace(a[i], map.get(a[i]) + 1);
            } else {
                map.put(a[i], 1);
                count += 1;
            }

            if(map.get(a[i-k])==1){
                count -=1;
            }
            else{
                if(map.get(a[i])==2){
                    count +=1;
                }
                map.replace(a[i-k],map.get(a[i-k])-1);
            }

            System.out.print(count + " ");
        }

    }
}
