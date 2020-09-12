package practice.data.stacks;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Waiter {
	/* < Input & Output >
	 * 
	 * Input Format
	 * N Q
	 * n1 n2 n3 n4 ...
	 * 
	 * Sample Input 0
	 * 5 1
	 * 3 4 7 6 5
	 * 
	 * Sample Output 0
	 * 4
	 * 6
	 * 3
	 * 7
	 * 5
	 */
	
	/* < Explanation >
	 * 
	 * Q가 0일 때, 
     * Stack A0
     * 
     * Q가 1일 때, 
     * Stack B1 / A1
     * - B1 : 2로 나눠지는 elements
     * - A1 : 나머지 모든 elements 
     * 
     * Q가 2일 때, 
     * Stack B1, B2 / A2 
     * - B1 : 2로 나눠지는 elements
     * - B2 : 3로 나눠지는 elements
     * - A2 : 나머지 모든 elements 
	 */
	/*
     * Complete the waiter function below.
     */
    static int[] waiter(int[] number, int q) {
        /*
         * Write your code here.
         */
    	int[][] stackA = new int[q+1][number.length];
    	int[] topA = new int[q+1];
    	Arrays.fill(topA, -1);
    	
    	int[][] stackB = new int[q][number.length];
    	int[] topB = new int[q];
    	
    	int[] result = new int[number.length];
    	int topR = 0;
    	
    	stackA[0] = number;
    	topA[0] = number.length-1;
    	
    	int[] prime = new int[q];
    	int topP = 0;
    	prime[topP] = 2;
    	
    	// Q 횟수만큼 미리 소수 찾아두기
		int prime_candidate = 2;
		while(topP != q-1) {
			
			prime_candidate++;
			
			int j=0;
			for(; j<topP; j++) {
				if(prime_candidate%prime[j] == 0) {
					break;
				}
			}
			if(j==topP) {
				prime[++topP] = prime_candidate;
			}
		}
    	
    	// Q 횟수만큼 반복 
    	for(int i=0; i<q; i++) {
    		
    		// Stack A 반복 
    		while(topA[i]>=0) {
    			
	    		// Stack A에서 pop 
	    		int tA = topA[i]--;
	    		int eleA = stackA[i][tA];
	    		
	    		// Stack A의 top 값이 prime으로 나눠지면, 
				if(eleA%prime[i] == 0) {
					
					// Stack B1에 push
					// Stack B2에 push
					// Stack B..에 push
					int tB = topB[i]++;
					stackB[i][tB] = eleA;
				}
				// Stack A의 top 값이 prime으로 나눠지지 않으면, 
				else {
					// Stack A1에 push
					// Stack A2에 push
					// Stack A..에 push
					int tA_of_next = ++topA[i+1];
					stackA[i+1][tA_of_next] = eleA;
				}
    		}
    	}
    	
    	// Stack B0, B1, B2.. 누적
    	for(int i=0; i<q; i++) {
    		
    		// Stack B0[0], B0[1], .. 누적 
    		int tB = --topB[i];
    		while(tB >= 0) {
    			result[topR++] = stackB[i][tB--];
    		}
    	}
    	
    	// 마지막 Stack A 누적 
    	int tA = topA[q];
    	while(tA >= 0) {
    		result[topR++] = stackA[q][tA--];
    	}
    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	// File에 작성 
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    	
    	// Console에 작성 
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    	
        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0].trim());

        int q = Integer.parseInt(nq[1].trim());

        int[] number = new int[n];

        String[] numberItems = scanner.nextLine().split(" ");

        for (int numberItr = 0; numberItr < n; numberItr++) {
            int numberItem = Integer.parseInt(numberItems[numberItr].trim());
            number[numberItr] = numberItem;
        }

        int[] result = waiter(number, q);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
