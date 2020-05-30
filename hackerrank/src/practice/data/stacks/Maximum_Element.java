package practice.data.stacks;

import java.util.Scanner;
import java.util.Stack;

public class Maximum_Element {
	
	public static void main(String[] args) {
		Stack<MyObject> stack = new Stack<MyObject>();
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int max = 0;
		while(n-- > 0) {
			int cmd = scan.nextInt();
			if(cmd == 1) {
				int item = scan.nextInt();
				max = (max < item) ? item : max;
				stack.push(new MyObject(item, max));
			}
			else if(cmd == 2) {
				stack.pop();
				max = (stack.size() > 0) ? stack.peek().max : 0;
			}
			else if(cmd == 3) {
				System.out.println(stack.peek().max);
			}
			else
				break;
		}
	}

	static class MyObject {
		public int value;
		public int max;
		
		MyObject(int value, int max) {
			this.value = value;
			this.max = max;
		}
	}
}
