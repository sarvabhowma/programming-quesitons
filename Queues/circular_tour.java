/*
There are n gas stations along a circular route,
where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and
it costs cost[i] of gas to travel from the ith station
to its next (i + 1)th station. You begin the journey
with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index
if you can travel around the circuit once in the clockwise direction,
otherwise return -1. If there exists a solution, it is guaranteed to be unique

Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3

Input: gas = [2,3,4], cost = [3,4,3]
Output: -1

 */

package Queues;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class circular_tour {


    public static int complete(int[] gas, int[] cost) {

        Queue<Integer> q = new LinkedList<>();
        int i=0;
        int count = 2*gas.length + 1;

        int tank=0;

        while((q.size()<gas.length+1) && (count>=1)){

            tank = tank+(gas[i]-cost[i]);
            q.add(i);

            while((tank<0) || (gas[q.peek()] - cost[q.peek()]<0)){

                tank = tank + ( cost[q.peek()] - gas[q.peek()] );
                q.remove();

                if(q.size()==0){
                    break;
                }

            }

            if(i+1 >= gas.length){
                i = 0;
            }
            else{
                i +=1;
            }

            count -=1;

        }

        if(count>=1){
            return q.peek();
        }
        else{
            return -1;
        }

    }

    public static void main(String args[]){

        int a[] = {2,3,4};
        int b[] = {3,4,3};

        System.out.println(complete(a,b));

    }
}
