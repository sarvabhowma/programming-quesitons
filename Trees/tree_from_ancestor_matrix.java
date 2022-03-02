/*
construct a tree from the ancestor matrix

Input: reading input from the file
6 // number of nodes
0 1 1 1 1 1 // 1 represents that node is a child of this node
0 0 0 0 0 1
0 0 0 1 1 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

Output :
number of nodes : 6

adjacency list of the nodes :

[2, 3, 4, 5, 6]
[6]
[4, 5]
null
null
null

displaying tree in level order format :

1 2 3 6 4 5

 */

package Trees;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class tree_from_ancestor_matrix {

    static class node {
        int value;
        node left, right;

        node(int k) {
            value = k;
            left = null;
            right = null;
        }
    }

    static void display(node root) {
        Queue<node> q = new LinkedList<>();
        q.add(root);

        while (q.size() != 0) {
            if (q.peek().left != null) {
                q.add(q.peek().left);
            }
            if (q.peek().right != null) {
                q.add(q.peek().right);
            }
            System.out.print(q.peek().value+" ");
            q.remove();
        }
    }

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(new File("src\\Trees\\test.txt"));

            int n = Integer.parseInt(sc.nextLine());

            Map<Integer, ArrayList<Integer>> t = new HashMap<>();// adjacency list of nodes
            Map<Integer, ArrayList<Integer>> m = new HashMap<>();// nodes based on children count

            System.out.println("number of nodes : "+n);
            int min = 99999; // minimum number of children
            int max = 0; // maximum number of children

            System.out.println("\nadjacency list of the nodes : \n");
            for (int i = 1; i <= n; i++) {
                String s[] = sc.nextLine().split(" ");
                int j = 1;

                for (String str : s) {
                    int x = Integer.parseInt(str);
                    if ((x != 0) && (!t.containsKey(i))) {
                        t.put(i, new ArrayList<Integer>());
                        t.get(i).add(j);
                    } else if (x != 0) {
                        t.get(i).add(j);
                    }
                    j++;
                }
                System.out.println(t.get(i));
                int size = 0;

                if (t.get(i) != null) {
                    size = t.get(i).size();
                }

                if (size > max) {
                    max = size;
                }
                if (size < min) {
                    min = size;
                }

                if (!m.containsKey(size)) {
                    m.put(size, new ArrayList<Integer>());
                    m.get(size).add(i);
                } else {
                    m.get(size).add(i);
                }

            }
            int visited[] = new int[n];
            Map<Integer, node> nodes = new HashMap<>(); // storing nodes of the value

            // creating nodes for the leaves
            if (min == 0) {
                for (int x : m.get(min)) {
                    nodes.put(x, new node(x));
                    nodes.get(x).left = null;
                    nodes.get(x).right = null;
                }
            }

            m.remove(0);

            // creating tree
            for (int i = min + 1; i <= max; i++) {
                if(m.containsKey(i)) {
                    for (int j : m.get(i)) {
                        int flag = 1;
                        node temp = new node(j);
                        nodes.put(j, temp);

                        for (int k : t.get(j)) {
                            if (visited[k - 1] == 0) {
                                if (flag == 1) {
                                    temp.left = nodes.get(k);
                                    visited[k - 1] = 1;
                                    flag += 1;
                                } else if (flag == 2) {
                                    temp.right = nodes.get(k);
                                    visited[k - 1] = 1;
                                    flag += 1;
                                }
                            }
                        }
                    }
                }
            }

            node root = nodes.get(m.get(max).get(0));

            System.out.println("\ndisplaying tree in level order format : \n");
            display(root);

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
