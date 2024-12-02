package programmers.kit.basic;

import java.util.Random;

public class Test1 {
	
	public static void main(String[] args) {
		
		Test1 obj = new Test1();
		
		Random r = new Random();
		int p0_x = Math.abs(r.nextInt())%1000000000;
		int p0_y = Math.abs(r.nextInt())%1000000000;
		int p1_x = Math.abs(r.nextInt())%1000000000;
		int p1_y = Math.abs(r.nextInt())%1000000000;
		
		int[][] origin_vector = new int[][]{
			{p0_x,p0_y},
			{p0_x,p1_y},
			{p1_x,p0_y},
			{p1_x,p1_y}};
		
		int[][] vector = new int[][] {
			origin_vector[0],
			origin_vector[1],
			origin_vector[2]
		};
	
		System.out.println(vector[0][0] + ", " + vector[0][1]);
		System.out.println(vector[1][0] + ", " + vector[1][1]);
		System.out.println(vector[2][0] + ", " + vector[2][1]);
		
		int[] result = obj.solution(vector);
		System.out.println(result[0] + ", " + result[1]);
	}
	
	public int[] solution(int[][] v) {
        int[] answer = {0,0};

        answer[0] = v[0][0] ^ v[1][0] ^ v[2][0];
        answer[1] = v[0][1] ^ v[1][1] ^ v[2][1];
        
        return answer;
    }
}
