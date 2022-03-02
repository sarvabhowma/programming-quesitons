/*
serialization and deserialization of a tree
serialization -- converting a tree to an array
deserialization -- getting the tree from the array

Input : taking from a text file
10 // number of nodes
2 3 4 // children list for each node
5 6
7 8 9
null
null
10
null
null
null
null

Output :
10

Before :
1 -> [2, 3, 4]
2 -> [5, 6]
3 -> [7, 8, 9]
6 -> [10]

[1, 2, 5, -1, 6, 10, -1, -1, -1, 3, 7, -1, 8, -1, 9, -1, -1, 4, -1, -1]

After :
1 -> [2, 3, 4]
2 -> [5, 6]
3 -> [7, 8, 9]
6 -> [10]


 */

package Trees;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class serial_and_deserial {

    static void serialization(Map<Integer, ArrayList<Integer>> m, int s, ArrayList<Integer> l) {
        if (!m.containsKey(s)) {
            l.add(s);
            l.add(-1);
            return;
        }

        l.add(s);

        for (int i : m.get(s)) {
            serialization(m, i, l);
        }
        l.add(-1);
        return;
    }

    static void deserialization(Map<Integer, ArrayList<Integer>> m, ArrayList<Integer> l, int s) {

        while (s < l.size()) {

            int i = s + 1;

            if (l.get(i) == -1) {
                l.remove(s);
                l.remove(s);
                return;
            }

            if (!m.containsKey(l.get(s))) {
                m.put(l.get(s), new ArrayList<Integer>());
                m.get(l.get(s)).add(l.get(i));
            } else {
                m.get(l.get(s)).add(l.get(i));
            }

            deserialization(m, l, i);
        }
    }

    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(new File("src\\Trees\\test.txt"));

            Map<Integer, ArrayList<Integer>> d = new HashMap<>();

            int n = Integer.parseInt(sc.nextLine());

            ArrayList<Integer> l = new ArrayList<>();

            System.out.println(n);

            System.out.println("\nBefore : ");

            for (int i = 1; i <= n; i++) {

                l = new ArrayList<>();

                String s[] = sc.nextLine().split(" ");

                for (String str : s) {
                    if (!str.equals("null"))
                        l.add(Integer.parseInt(str));
                }
                if (l.size() != 0) {
                    d.put(i, l);
                    System.out.println(i + " -> " + d.get(i));
                }

            }
            System.out.println();

            serialization(d, 1, l);
            System.out.println(l);

            Map<Integer, ArrayList<Integer>> m1 = new HashMap<>();
            deserialization(m1, l, 0);

            System.out.println("\nAfter : ");

            for (Integer k : m1.keySet()) {
                System.out.println(k+" -> "+m1.get(k));
            }

        } catch (FileNotFoundException e) {

            System.out.println(e);

        }


    }
}
