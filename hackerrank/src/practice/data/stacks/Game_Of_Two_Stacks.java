package practice.data.stacks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Game_Of_Two_Stacks {

	/*
     * Complete the twoStacks function below.
     */
    static int twoStacks(int x, int[] a, int[] b) {
        /*
         * Write your code here.
         */

    	Stack<Integer> stack1 = new Stack<Integer>();
    	Stack<Integer> stack2 = new Stack<Integer>();
    	
    	Stack<Integer> sumA = new Stack<Integer>();
    	Stack<Integer> sumB = new Stack<Integer>();
    	
    	for(int i=a.length-1; i>=0; i--) {
    		stack1.push(a[i]);
    	}
    	for(int i=b.length-1; i>=0; i--) {
    		stack2.push(b[i]);
    	}
    	
//    	int sum = 0;
//    	while(!stack1.empty() && sum > x) {
//    		int ele = stack1.pop();
//    		sumA.push(ele);
//    		sum += ele;
//    	}
//    	
//    	while(!stack2.empty()) {
//    		int ele = stack2.pop();
//    		sumB.push(ele);
//    		sum += ele;
//    		
//    		while(sum > x) {
//    			sumA.pop();
//    		}
//    		
//    	}
    	
    	int sum = 0;
    	int cnt = 0;
    	while(sum <= x) {
    		
    		int s1 = !stack1.empty() ? stack1.peek() : Integer.MAX_VALUE;
    		int s2 = !stack2.empty() ? stack2.peek() : Integer.MAX_VALUE;
    		
    		if(s1 < s2) {
    			sum += stack1.pop();
    		}
    		else if(s1 > s2){
    			sum += stack2.pop();
    		}
    		else if(s1 == s2 && s1 != Integer.MAX_VALUE) {
    			sum += stack1.pop();
    		}
    		else {
    			break;
    		}
    		cnt++;
    	}
    	
    	if(sum > x)
    		--cnt;
    	return cnt;
    }
    

//    private static final Scanner scanner = new Scanner(System.in);
    		
	public static void main(String[] args) throws IOException {
		Scanner scanner = null;
		
		// output
		File f2 = new File("../Game_Of_Two_Stacks_output01.txt");
		try {
	    	scanner = new Scanner(f2);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		
		ArrayList<Integer> outList = new ArrayList<Integer>();
		while(scanner.hasNext()) {
			String outStr = scanner.nextLine();
			int out = Integer.parseInt(outStr);
			outList.add(out);
		}
		
		// input
		File f = new File("../Game_Of_Two_Stacks_input01.txt");
	    
	    try {
	    	scanner = new Scanner(f);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());

            int m = Integer.parseInt(nmx[1].trim());

            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];

            String[] bItems = scanner.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);
            if(outList.get(gItr) != result) {
            	System.out.println("Error : " + gItr);
            }
            
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

        System.out.println("success");
//        bufferedWriter.close();
    }
}
