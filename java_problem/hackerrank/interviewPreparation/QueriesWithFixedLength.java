package hackerrank.interviewPreparation;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

// Prepare > Interview > Preparation Kits > 1 Month Preparation Kit > Week 4 > Queries with Fixed Length
// 수준 : Intermediate / 성공률 (72.46%)
// 문제 : 주어진 배열에서 q 만큼의 윈도우가 있다고 했을 때, 각 윈도우에서 가장 큰 값들을 모은 후, 그 값들 중 가장 작은 값을 찾는 문제
// 풀이 검사 : 테스트 일부 통과(정확도 통과, 시간 타임 초과)

//5 2
//2 3 4 5 6
//2
//3

//5 5
//1 2 3 4 5
//1
//2
//3
//4
//5

//5 5
//33 11 44 11 55
//1
//2
//3
//4
//5
public class QueriesWithFixedLength {
    public static List<Integer> solve(List<Integer> arr, List<Integer> queries) {
        List<Integer> result = new ArrayList<>();
        for (Integer query : queries) {
            int min = Integer.MAX_VALUE;
            for (int i=0; i<=arr.size()-query; i++) {
                int max = Integer.MIN_VALUE;
                for (int j=i; j<i+query; j++) {
                    if (max < arr.get(j)) {
                        max = arr.get(j);
                    }
                }
                if (min > max) {
                    min = max;
                }
            }
            result.add(min);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> queries = IntStream.range(0, q).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = QueriesWithFixedLength.solve(arr, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
