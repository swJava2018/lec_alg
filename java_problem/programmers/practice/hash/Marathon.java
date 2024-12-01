package programmers.practice.hash;

import java.util.HashMap;

// 완주하지 못한 선수
// 참여자(participant) 명단에 있지만, 완주자(completion) 명단에 없는 선수가 결과로 반환되어야 합니다.
public class Marathon {
	
	public static void main(String[] args) {
	
		Marathon problem = new Marathon();

		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		System.out.println("result : " + problem.solution(participant, completion));

		participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
		completion = new String[]{"josipa", "filipa", "marina", "nikola"};
		System.out.println("result : " + problem.solution(participant, completion));

		participant = new String[]{"mislav", "stanko", "mislav", "ana"};
		completion = new String[]{"stanko", "ana", "mislav"};
		System.out.println("result : " + problem.solution(participant, completion));
	}
	
	// for 문을 사용 
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        for(int i=0; i<participant.length; i++) {
        	int j=0;
        	while(j<completion.length) {
        		if(participant[i] == completion[j]) {
        			completion[j] = "";
        			break;
        		}
        		j++;
        	}
        	if(j==completion.length) {
        		answer = participant[i];
        		break;
        	}
        }
        return answer;
    }
	// hash를 사용 
	public String solution2(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Boolean> map = new HashMap<>();
        for(int i=0; i<completion.length; i++)
        	map.put(completion[i], true);

        for(int i=0; i<participant.length; i++) {
        	Boolean check = map.get(participant[i]);
        	if(check != null) {
        		if(check == true) {
            		map.replace(participant[i], false);
        		}
        		else {
        			answer = participant[i];
        			break;
        		}
        	}
        	else {
        		answer = participant[i];
        		break;
        	}
        }
        
        return answer;
    }
}
