/*
breaking a string into valid words

Input:
iamgoodboy

Output:
t t t f t f t f f t
* t t f t f t f f t
* * f f f f f f f f
* * * f t f t f f t
* * * * f f f f f f
* * * * * f f f f f
* * * * * * f f f f
* * * * * * * f f t
* * * * * * * * f f
* * * * * * * * * f
i am good boy

 */

package dynamic_programming;

import java.util.*;

public class word_breaking_problem {

    static boolean check(char[][] a, int x, int y) {

        char p = 'f', q = 'f';

        for (int i = y; i >= 0; i--) {
            if (a[x][i] == 't') {
                p = 't';
                break;
            }
        }

        for (int i = x; i < a.length; i++) {
            if (a[i][y] == 't') {
                q = 't';
                break;
            }
        }

        if (p == 't' && q == 't') {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Map<String, Integer> m = new HashMap<>();
        m.put("i", 1);
        m.put("a", 1);
        m.put("am", 1);
        m.put("go", 1);
        m.put("good", 1);
        m.put("boy", 1);
        m.put("what", 1);
        m.put("is", 1);
        m.put("name", 1);
        int n = s.length();
        char a[][] = new char[n][n];

        for (int i = 0; i < n; i++) {
            int k = 0;
            for (int j = 0; j < i; j++) {
                a[i][j] = '*';
            }
            for (int j = i; j < n; j++, k++) {
                if (check(a, k, j) || m.containsKey(s.substring(k, j + 1))) {
                    a[k][j] = 't';
                } else {
                    a[k][j] = 'f';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        List<int[]> l = new ArrayList<>();
        int count = 0;
        l.add(new int[]{0, n - 1});

        while (count < l.size()) {
            int x = l.get(count)[0];
            int y = l.get(count)[1];
            int flag = 0;

            for (int i = y - 1; i >= 0; i--) {
                if (a[x][i] == 't' && a[i + 1][y] == 't') {
                    l.add(new int[]{x, i});
                    l.add(new int[]{i + 1, y});
                    l.remove(count);
                    flag += 1;
                    break;
                }
            }
            if (flag == 0) {
                count += 1;
            }

        }
        Map<Integer, Integer> m1 = new HashMap<>();
        for (int[] c : l) {
            m1.put(c[0], c[1]);
        }
        int index = 0;
        while (index < s.length() - 1) {
            System.out.print(s.substring(index, m1.get(index) + 1) + " ");
            index = m1.get(index) + 1;
        }
    }
}


