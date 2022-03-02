/*
displaying tree if edges are given

Input: read from the file
a b
b c
d e
a f
d g
b h
c m
e k

Output:
[a, b, c, d, e, f, g, h, m, k]
-->a
   |-->b
   |   |-->c
   |   |   |-->m
   |   |-->h
   |-->f

-->d
   |-->e
   |   |-->k
   |-->g

 */

package Trees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class tree_problem {

    static void display(Map<Character,ArrayList<Character>> t, ArrayList<Character> visited){

        Stack<Character> s = new Stack<>();
        s.push(visited.get(0));
        System.out.println("-->"+visited.get(0));
        visited.remove(visited.get(0));

        while(s.size()!=0){
            char c = ' ';

            if(t.containsKey(s.peek())){
                for(char i: t.get(s.peek())){
                    if(visited.contains(i)){
                        c = i;
                        break;
                    }
                }
            }

            if(c!=' '){
                for(int i=0;i<s.size();i++){
                    System.out.print("   |");
                }
                System.out.println("-->"+c);
                visited.remove(new Character(c));
                s.push(c);
            }
            else{
                s.pop();
            }
        }
    }

    public static void main(String[] args){

        try{
            Scanner sc = new Scanner(new File("src\\Trees\\test.txt"));
            Map<Character,ArrayList<Character>> t = new HashMap<>();

            String s = " ";
            ArrayList<Character> visited = new ArrayList<>();

            while(!(s=sc.nextLine()).equals("")){
                char a = s.charAt(0);
                char b = s.charAt(2);
                if(!t.containsKey(a)){
                    t.put(a,new ArrayList<Character>());
                    t.get(a).add(b);
                }
                else{
                    t.get(a).add(b);
                }
                if(!visited.contains(a)){
                    visited.add(a);
                }
                if(!visited.contains(b)){
                    visited.add(b);
                }
            }

            System.out.println(visited);

            while(visited.size()!=0){
                display(t,visited);
                System.out.println();
            }



        }catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
}
