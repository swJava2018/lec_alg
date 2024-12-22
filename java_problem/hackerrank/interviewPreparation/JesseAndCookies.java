package hackerrank.interviewPreparation;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

// Prepare > Interview > Preparation Kits > 1 Month Preparation Kit > Week 4 > Jesse and Cookies
// 수준 : Intermediate / 성공률 (79.36%)
// 문제 : 쿠키 쿱기
// 풀이 검사 : 테스트 모두 통과

public class JesseAndCookies {
    public static int cookies(int k, List<Integer> A) {
        // check if creating combined cookie is impossible
        if (A.size() < 2) {
            return -1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<A.size(); i++) {
            pq.add(A.get(i));
        }

        int loopCnt = 0;
        int leastCookie = pq.poll();
        while (leastCookie < k){
            // check if creating combined cookie is impossible
            if (pq.isEmpty()) {
                return -1;
            }

            pq.add(leastCookie + pq.poll()*2);
            leastCookie = pq.poll();
            loopCnt++;
        }
//        System.out.println(pq);
        return loopCnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
