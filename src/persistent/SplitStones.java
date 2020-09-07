package persistent;

import java.util.Scanner;

public class SplitStones {
    public void split(int[] arr) {
        if ((arr[0] + arr[1] + arr[2]) != (arr[3] + arr[4]))
            System.out.println("NO");
        else if (arr[3] < Math.min(arr[0], Math.min(arr[1], arr[2])) || arr[4] < Math.min(arr[0], Math.min(arr[1], arr[2])))
            System.out.println("NO");
        else
            System.out.println("YES");
    }

    public static void main(String[] args) {
        SplitStones o = new SplitStones();
        Scanner in = new Scanner(System.in);

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = in.nextInt();
        }

        o.split(arr);
    }
}
