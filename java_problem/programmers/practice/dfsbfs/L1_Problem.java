package programmers.practice.dfsbfs;

public class L1_Problem {

	public static void main(String[] args) {
//		int[] numbers = new int[] {1, 1, 1, 1, 1};
		int[] numbers = new int[] {2, 3, 5, 7, 9};
		int target = 2;
		
		L1_Problem obj = new L1_Problem();
		
		int result = obj.solution(numbers, target);
		System.out.println(result);
	}
	
	public int count(int[] numbers, int target, int idx) {
        if(idx == numbers.length-1) {
            int cnt = 0;
            cnt += (target - numbers[idx] == 0) ? 1 : 0;
            cnt += (target + numbers[idx] == 0) ? 1 : 0;
            
            // debug
            if(cnt == 1) {
            	for(int i=0; i<numbers.length; i++)
            		System.out.print(numbers[i] + ", ");
            	System.out.println();
            }
            return cnt;
        } else {
            int cnt = 0;
            cnt += count(numbers, target - numbers[idx], idx+1);
            cnt += count(numbers, target + numbers[idx], idx+1);
            return cnt;
        }
    } 
    
    public int solution(int[] numbers, int target) {
        
        // 평균 != 소수점
        // 평균 < target, numbers 3개 이상
//        int answer = 0;
//        answer = count(numbers, target, 0);
//        return answer;
        
    	int answer=0;
    	for(int k=0; k<(1<<numbers.length); k++) {
    		
    		int sum = 0;
	        for(int i=0; i<numbers.length; i++) {
	        	if((1<<i & numbers[i]) > 0)
	        		sum += numbers[i];
	        	else
	        		sum -= numbers[i];
	        }
	        
	        if(sum == target) {
	        	answer++;
	        	
	        	for(int i=0; i<numbers.length; i++)
            		System.out.print(numbers[i] + ", ");
            	System.out.println();
	        }
    	}
        return answer;
    }
}
