package hackerrank.practice.ds;

import java.util.ArrayList;
import java.util.List;

public class Concept {
	public static void main(String[] args) {
		
//		2 5
//		1 0 5
//		1 1 7
//		1 0 3
//		2 1 0
//		2 1 1
		
//		a[0] = a[0][0], a[0][1]
//		a[1] = a[1][0], a[1][1], a[1][2]
//		a[2] = a[2][0]
		
//		Integer[][] 고정된 2차원 배열 
//		초기에 크기 : a[3][] 
//		사용할 때 : 3개 줄만 사용 
//		
//		List<List<Integer>> 가변크기의 2차원 배열 
//		초기에 크기 : a[0][0] 
//		사용할 때 : 필요한 만큼 그때마다 추가해서 사용
		
		Integer[][] queries1 = new Integer[3][];
//		..
//		..
//		..
//		..
		queries1[0] = new Integer[2];
		queries1[1] = new Integer[3];
		queries1[2] = new Integer[1];
		
		List<List<Integer>> queries2 = new ArrayList<List<Integer>>();
//		..
//		..
//		..
//		..
		queries2.add(new ArrayList<Integer>());
		queries2.add(new ArrayList<Integer>());
		
		queries2.get(0).add(11);
		queries2.get(0).add(12);
		queries2.get(1).add(21);
		queries2.get(1).add(22);
		queries2.get(1).add(22);
		
		for(int i=0; i<queries2.size(); i++) {
			
			List<Integer> list = queries2.get(i);
			for(int j=0; j<list.size(); j++) {
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}
	}
}
