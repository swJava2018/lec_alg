package practice.data.stacks;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
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

    	Stack<Integer> stackA = new Stack<Integer>();
    	Stack<Integer> stackB = new Stack<Integer>();
    	
    	for(int i=a.length-1; i>=0; i--) {
    		stackA.push(a[i]);
    	}
    	for(int i=b.length-1; i>=0; i--) {
    		stackB.push(b[i]);
    	}
    	
//    	System.out.println("stackA : " + stackA.toString());
//    	System.out.println("stackB : " + stackB.toString());
    	
    	int sum = 0;
    	ArrayDeque<Integer> queA = new ArrayDeque<Integer>();
    	
    	// Sum에 Stack A에 대해서만 우선 반영한다. 
    	for(int i=0; i<a.length; i++) {
			int val = stackA.pop();
			if(sum + val > x)
				break;
			
			sum += val;			// sum 안에 들어간 a 의 합 
			queA.offer(val);	// sum 안에 반영된 a 개수와 값 
    	}
    	
//    	System.out.println("stackA : " + stackA.toString());
//    	System.out.println("stackB : " + stackB.toString());
//    	System.out.println("queA : " + queA.toString());
    	
    	// Sum에 Stack A 원소의 개수 
    	int cnt = queA.size();
    	
    	// Sum에 Stack B에 대한 내용을 추가 반영한다. (단, 기존 Stack A로 반영된 값을 일부 제거한다.)
    	for(int i=0; i<b.length; i++) {
//    			System.out.println("[0] i: " + i + ", x: " + x + ", sum: " + sum + ", Q: " + queA.toString() + ", b: " + stackB.peek() + ", cnt: " + cnt);
    			
    			// sum 안에 b값 1개 추가 (sum값이 x값을 넘어가는 시점) 
    			sum += stackB.pop();			
    			
    			// sum 안에 추가된 b값만큼 a값 제거 (sum값이 x값 아래로 내려가는 시점) 
    			while(sum > x && !queA.isEmpty()) {		
    				sum -= queA.pollLast();
    			}
    			
    			// (충족된) sum을 구성하는 a와 b에 대한 갯수 갱신
    			int cnt_tmp = queA.size() + (i+1);
    			if(sum <= x && cnt_tmp > cnt) {
    				cnt = cnt_tmp;
    			}
    			
//    			System.out.println("[+] i: " + i + ", x: " + x + ", sum: " + sum + ", Q: " + queA.toString() + ", b: " + stackB.peek() + ", cnt: " + cnt);
    	}
    	
    	return cnt;
    	
//		잘못된 접근방식 
//    	int sum = 0;
//    	int cnt = 0;
//    	while(sum <= x) {
//    		
//    		int s1 = !stack1.empty() ? stack1.peek() : Integer.MAX_VALUE;
//    		int s2 = !stack2.empty() ? stack2.peek() : Integer.MAX_VALUE;
//    		
//    		if(s1 < s2) {
//    			sum += stack1.pop();
//    		}
//    		else if(s1 > s2){
//    			sum += stack2.pop();
//    		}
//    		else if(s1 == s2 && s1 != Integer.MAX_VALUE) {
//    			sum += stack1.pop();
//    		}
//    		else {
//    			break;
//    		}
//    		cnt++;
//    	}
//    	
//    	if(sum > x)
//    		--cnt;
//    	return cnt;
    }
    

//    private static final Scanner scanner = new Scanner(System.in);
    		
	public static void main(String[] args) throws IOException {
		Scanner scanner = null;
		
		// output
		File f2 = new File("/Users/dean/git/lec_alg/hackerrank/src/practice/data/stacks/Game_Of_Two_Stacks_output01.txt");
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
		File f = new File("/Users/dean/git/lec_alg/hackerrank/src/practice/data/stacks/Game_Of_Two_Stacks_input01.txt");
	    
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
            	System.out.println("Error i : " + gItr + ", Expect : " + outList.get(gItr) + ", Real : " + result);
            }
            
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

        System.out.println("success");
//        bufferedWriter.close();
    }
}
