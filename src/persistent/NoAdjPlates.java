package persistent;

/*
Problem Statement – : Ramu has N dishes of different types arranged in a row: A1,A2,…,AN where Ai denotes the type of the ith dish. He wants to choose as many dishes as possible from the given list but while satisfying two conditions:

He can choose only one type of dish.
No two chosen dishes should be adjacent to each other.
Ramu wants to know which type of dish he should choose from, so that he can pick the maximum number of dishes.

Example :
Given N= 9 and A= [1,2,2,1,2,1,1,1,1]
For type 1, Ramu can choose at most four dishes. One of the ways to choose four dishes of type 1 is A1,A4, A7 and A9.
For type 2, Ramu can choose at most two dishes. One way is to choose A3 and A5.
So in this case, Ramu should go for type 1, in which he can pick more dishes.

INPUT FORMAT:

The first line contains T, the number of test cases. Then the test cases follow.
For each test case, the first line contains a single integer
The second line contains N integers A1,A2,…,AN.
OUTPUT FORMAT  :

For each test case, print a single line containing one integer ― the type of the dish that Ramu should choose from. If there are multiple answers, print the smallest one.
 */

import java.util.Scanner;

public class NoAdjPlates {
    public void choosePlates(int num, int[] arr) {
        int[] types = new int[num];

        for (int i = 0; i < arr.length-1; i++) {
            types[arr[i]]++;
            if (arr[i] == arr[i+1]) i++;
        }
        int max = types[0];
        int x = 0;
        for (int i = 0; i < types.length; i++) {
            if (max < types[i]) {
                max = types[i];
                x = i;
            }
        }
        System.out.println(max + " " + x);
    }

    public static void main(String[] args) {
        NoAdjPlates o = new NoAdjPlates();
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        int[] arr = new int[num+1];

        for (int i = 0; i < num; i++)
            arr[i] = in.nextInt();

        o.choosePlates(num, arr);
    }
}
