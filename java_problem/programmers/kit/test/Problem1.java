package programmers.kit.test;

import java.util.Stack;

public class Problem1 {
	public static void main(String[] args) {
		
		// stack 사용법
//		Stack<Integer> stack = new Stack<Integer>();
//		
//		stack.push(3);
//		System.out.println("size: " + stack.size());
//		
//		int item = stack.peek();
//		System.out.println(item);
//		System.out.println("size: " + stack.size());
//		
//		item = stack.pop();
//		System.out.println(item);
//		System.out.println("size: " + stack.size());
		
		// programmers 문제 풀이 방법
		Problem1 obj = new Problem1();
		
		int[][] board = new int[][] {
			{0,0,0,0,0}, 
			{0,0,1,0,3},
			{0,2,5,0,1},
			{4,2,4,4,2},
			{3,5,1,3,1}};
//		int[] moves = new int[] {1,5,3,5,1,2,1,4};
		int[] moves = new int[] {1,4,1,4};
		int result = obj.solution(board, moves);
		System.out.println(result);
	}
	
	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        int[][] board2 = new int[board.length][board.length];
        
        // 1. 판 회전 
        for(int i=0; i<board2.length; i++) {
        	for(int j=0; j<board2.length; j++) {
        		board2[j][i] = board[i][j];
        	}
        }
        
        for(int k=0; k<moves.length; k++) {
        	
        	int m = moves[k]-1;
        	for(int i=0; i<board2.length; i++) {
        		if(board2[m][i] != 0) {
        			int item = board2[m][i];
        			board2[m][i] = 0;
        			
        			if(stack.empty() == false && stack.peek() == item) {
        				stack.pop();
        				answer += 2;
        			}
        			else {
        				stack.push(item);
        			}
        			System.out.println(k + ":" + stack.toString());
        			break;
        		}
        	}
        }
        return answer;
    }
}
