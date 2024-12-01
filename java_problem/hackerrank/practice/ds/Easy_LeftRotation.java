package hackerrank.practice.ds;

import java.util.Scanner;

public class Easy_LeftRotation {
	
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        scanner.close();
        
        // TODO
        // 5 4
        // 1 2 3 4 5
        // => 5 1 2 3 4
        //
        // => index : 0 -> 4 (i+4) == +d
        // => index : 1 -> 0 (i-1) == -(n-d)
        // => index : 2 -> 1 (i-1) == -(n-d)
        // => index : 3 -> 2 (i-1) == -(n-d)
        // => index : 4 -> 3 (i-1) == -(n-d)
        //
        // 5 3
        // 1 2 3 4 5
        // => 4 5 1 2 3
        //
        // => index : 0 -> 3 (i+3) == +d
        // => index : 1 -> 4 (i+3) == +d
        // => index : 2 -> 0 (i-2) == -(n-d)
        // => index : 3 -> 1 (i-2) == -(n-d)
        // => index : 4 -> 2 (i-2) == -(n-d)
        //
        // 5 1
        // 1 2 3 4 5
        // => 2 3 4 5 1
        //
        // => index : 0 -> 1 (i+1) == +d
        // => index : 1 -> 2 (i+1) == +d
        // => index : 2 -> 3 (i+1) == +d
        // => index : 3 -> 4 (i+1) == +d
        // => index : 4 -> 0 (i-4) == -(n-d)
        //
        // (i+d)%n
        
        
        
        
        for (int i = 0; i < n; i++) {
        	int idx = (i+d)%n;
        	System.out.print(a[idx] + " ");
        }
        System.out.println();
    }
}
