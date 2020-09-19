package practice.data.queue;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * 문제 설명 
 * operation 1은 queue에 추가
 * operation 2는 queue에서 제거 
 * operation 3는 queue의 front값 출력 
 */

public class Queue_Using_Tow_Stacks {
	
	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		
		// Queue 생성
		LinkedList<String> queue = new LinkedList<String>();
		
		// Input 길이  
		int input_len = Integer.parseInt(scanner.nextLine());
		
		for(int i=0; i<input_len; i++) {
			
			String[] inputs = scanner.nextLine().split(" ");
			if(inputs[0].equals("1")) {
				queue.add(inputs[1]);
			} else if(inputs[0].equals("2")) {
				queue.poll();
			} else {
				String ele = queue.peek();
				System.out.println(ele);
			}
		}
    }
}
