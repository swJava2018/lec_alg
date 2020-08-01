package practice.data.stacks;

import java.nio.CharBuffer;
import java.util.Scanner;
import java.util.Stack;

public class Simple_Text_Editor {
	
	private static final Scanner scanner = new Scanner(System.in);
	
//	static class Undo {
//	int op;
//	int len;
//	
//	Undo(int op, int len) {
//		this.op = op;
//		this.len = len;
//	}
//}
//	
//	public static void main(String[] args) {
//		char[] stack = new char[1000000];
//		int top = 0;
//		Stack<Undo> undoStack = new Stack<Undo>();
//		
//		
//		int n = Integer.parseInt(scanner.nextLine().trim());	
//		while(n-- > 0) {
//			String[] cmd = scanner.nextLine().split(" ");
//			
//			int op = Integer.parseInt(cmd[0]);
//			switch(op) {
//			
//			// append
//			case 1:
//				for (int i=0; i<cmd[1].length(); i++) {
//					stack[top++] = cmd[1].charAt(i);
//				}
//				undoStack.push(new Undo(op, cmd[1].length()));
//				break;
//				
//			// delete
//			case 2:
//				int del_len = Integer.parseInt(cmd[1]);
//				top -= del_len;
//				undoStack.push(new Undo(op, del_len));
//				break;
//			
//			// print
//			case 3:
//				int out_i = Integer.parseInt(cmd[1]);
//				System.out.println(stack[out_i-1]);
//				break;
//				
//			// undo	
//			case 4:
//				Undo prev = undoStack.pop();
//				if(prev.op == 1) {
//					top -= prev.len;
//				} else {
//					top += prev.len;
//				}
//				break;
//				
//			default:
//				break;
//			}
//		}
//	}
	
//	static class Undo {
//		int op;
//		String word;
//		
//		Undo(int op, String word) {
//			this.op = op;
//			this.word = word;
//		}
//	}
//	public static void main(String[] args) {
//		Stack<Character> stack = new Stack<Character>();
//		Stack<Undo> history = new Stack<Undo>();
//		
//		int n = Integer.parseInt(scanner.nextLine().trim());	
//		while(n-- > 0) {
//			String[] cmd = scanner.nextLine().split(" ");
//			
//			int op = Integer.parseInt(cmd[0]);
//			switch(op) {
//			
//			// append
//			case 1:
//				for (int i=0; i<cmd[1].length(); i++) {
//					stack.push(cmd[1].charAt(i));
//				}
//				history.push(new Undo(op, cmd[1]));
//				break;
//				
//			// delete
//			case 2:
//				String tmp = "";
//				for (int i=0; i<Integer.parseInt(cmd[1]); i++) {
//					tmp = stack.pop() + tmp;
//				}
//				history.push(new Undo(op, tmp));
//				break;
//			
//			// print
//			case 3:
//				int out_i = Integer.parseInt(cmd[1]);
//				System.out.println(stack.get(out_i-1));
//				break;
//				
//			// undo	
//			case 4:
//				Undo prev = history.pop();
//				if(prev.op == 1) {
//					for (int i=0; i<prev.word.length(); i++) {
//						stack.pop();
//					}
//				} else {
//					for (int i=0; i<prev.word.length(); i++) {
//						stack.push(prev.word.charAt(i));
//					}
//				}
//				break;
//				
//			default:
//				break;
//			}
//		}
//	}
	
	static class Txt {
		int op;
		String word;
		
		Txt(int op, String word) {
			this.op = op;
			this.word = word;
		}
	}
	
	public static void main(String[] args) {
		Stack<Txt> history = new Stack<Txt>();
		String result = "";
		
		int n = Integer.parseInt(scanner.nextLine().trim());	
		while(n-- > 0) {
			String[] cmd = scanner.nextLine().split(" ");
			
			int op = Integer.parseInt(cmd[0]);
			switch(op) {
			
			// append
			case 1:
				result += cmd[1];
				history.push(new Txt(op, cmd[1]));
				break;
				
			// delete
			case 2:
				int del_len = Integer.parseInt(cmd[1]);
				history.push(new Txt(op, result.substring(result.length() - del_len)));
				result = result.substring(0, result.length() - del_len);
				break;
			
			// print
			case 3:
				int out_i = Integer.parseInt(cmd[1]);
				System.out.println(result.charAt(out_i-1));
				break;
				
			// undo	
			case 4:
				Txt prev = history.pop();
				if(prev.op == 1) {
					int del_len2 = prev.word.length();
					result = result.substring(0, result.length() - del_len2);
				} else {
					result += prev.word;
				}
				break;
				
			default:
				break;
			}
		}
	}
}
