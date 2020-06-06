package practice.data.stacks;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Equal_Stacks {

	static int min(int a, int b, int c) {
		if(a <= b && a <= c)
			return a;
		else if (b <= a && b <= c)
			return b;
		else
			return c;
	}
    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */

    	Stack<Integer> stack1 = new Stack<Integer>();
    	Stack<Integer> stack2 = new Stack<Integer>();
    	Stack<Integer> stack3 = new Stack<Integer>();
    	
    	int s1=0, s2=0, s3=0;
    	
    	for(int i=h1.length-1; i>=0; i--) {
    		stack1.push(h1[i]);
    		s1 += h1[i];
    	}
    	for(int i=h2.length-1; i>=0; i--) {
    		stack2.push(h2[i]);
    		s2 += h2[i];
    	}
    	for(int i=h3.length-1; i>=0; i--) {
    		stack3.push(h3[i]);
    		s3 += h3[i];
    	}
    	
    	while (!stack1.empty() || !stack2.empty() || !stack3.empty()) {
    		
    		if(s1 == s2 && s2 == s3) {
    			return s1;
    		}
    		
    		int misS = min(s1, s2, s3);
    		
    		while (misS < s1) {
    			s1 -= stack1.pop();
    		}
    		while (misS < s2) {
    			s2 -= stack2.pop();
    		}
    		while (misS < s3) {
    			s3 -= stack3.pop();
    		}
    	}
    	
    	return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
    }
}
