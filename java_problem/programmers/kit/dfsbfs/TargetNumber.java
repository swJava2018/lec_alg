package programmers.kit.dfsbfs;

// 타겟 넘버
// 음이 아닌 정수들(numbers)의 순서를 바꾸지 않고, 덧셈/뺄셈으로 타깃 넘버를 만드는 방법의 수를 반환합니다.
public class TargetNumber {
	public static void main(String[] args) {
		TargetNumber problem = new TargetNumber();

		// 예 1)
		// -1+1+1+1+1 = 3
		// +1-1+1+1+1 = 3
		// +1+1-1+1+1 = 3
		// +1+1+1-1+1 = 3
		// +1+1+1+1-1 = 3
		int[] numbers = new int[] {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println("result : " + problem.solution(numbers, target));
	}

	public int solution(int[] numbers, int target) {
		return dfs(numbers, target, 0);
	}
	
	public int dfs(int[] numbers, int target, int idx) {
		int cnt = 0;
		if(idx == numbers.length-1) {
			// 모든 마지막 노드는 덧셈, 뺄셈 두개의 계산을하는 노드로 종료됩니다.
			cnt += (target - numbers[idx] == 0) ? 1 : 0;
            cnt += (target + numbers[idx] == 0) ? 1 : 0;
		} else {
			// 루트 노트부터 덧셈, 뺄셈 두개의 트리로 시작합니다.
			// 루트 노드 1: -1 ...
			// 루트 노트 2: +1 ...
			cnt += dfs(numbers, target - numbers[idx], idx+1);
            cnt += dfs(numbers, target + numbers[idx], idx+1);
		}
		return cnt;
	}
}
