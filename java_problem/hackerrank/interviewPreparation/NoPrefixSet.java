package hackerrank.interviewPreparation;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

// 소요시간 : 44분
// 1:36-1:43 문제 이해 완료
// 1:43-1:43 문제 솔루션 생각 완료
// 1:43-1:20 문제 솔루션 코드 완료

// Prepare > Interview > Preparation Kits > 1 Month Preparation Kit > Week 4 > Lily's Homework
// 수준 : Intermediate / 성공률 (73.70%)
// 문제 : 주어진 배열(word)의 문자들에서 (이전에 입력된 문자열들 중에) prefix 가 발견되는 경우, 최근에 입력된 문자열을 "BAD SET"과 함께 출력하고, 발견되지 않을 경우 "GOOD SET"과 함꼐 출력하기
// 풀이 검사 : 테스트 일부 통과(정확도 통과, 시간 타임 초과)
// 풀이 접근 : 완전 탐색

public class NoPrefixSet {
    public static void noPrefix(List<String> words) {
        if (words.size() == 1) {
            System.out.println("GOOD SET");
            return;
        }

        if (words.size() == 2 && words.get(0).equals(words.get(1))) {
            System.out.printf("BAD SET\n%s", words.get(1));
            return;
        }

        HashSet<String> exist = new HashSet<>();
        exist.add(words.get(0));

        for (int i=1; i<words.size(); i++) {
            // remove duplicated word for performance
            if (exist.contains(words.get(i))) {
                continue;
            } else {
                exist.add(words.get(i));
            }

            for (int j=i-1; j>=0; j--) {
                int prevWordLen = words.get(j).length();
                int currWordLen = words.get(i).length();
                if (prevWordLen < currWordLen
                        && words.get(j).equals(words.get(i).subSequence(0, prevWordLen))) {
                    System.out.printf("BAD SET\n%s", words.get(i));
                    return;
                } else if (prevWordLen > currWordLen
                        && words.get(i).equals(words.get(j).subSequence(0, currWordLen))) {
                    System.out.printf("BAD SET\n%s", words.get(i));
                    return;
                } else if (words.get(i).equals(words.get(j))) {
                    System.out.printf("BAD SET\n%s", words.get(i));
                    return;
                }
            }
        }
        System.out.println("GOOD SET");
    }

    /*public static void noPrefix(List<String> words) {
        if (words.size() == 1) {
            System.out.println("GOOD SET");
            return;
        }
        for (int i=1; i<words.size(); i++) {
            for (int j=i-1; j>=0; j--) {
                int prevWordLen = words.get(j).length();
                int currWordLen = words.get(i).length();
                if (prevWordLen < currWordLen
                        && words.get(j).equals(words.get(i).subSequence(0, prevWordLen))) {
                    System.out.printf("BAD SET\n%s", words.get(i));
                    return;
                } else if (prevWordLen > currWordLen
                        && words.get(i).equals(words.get(j).subSequence(0, currWordLen))) {
                    System.out.printf("BAD SET\n%s", words.get(i));
                    return;
                } else if (words.get(i).equals(words.get(j))) {
                    System.out.printf("BAD SET\n%s", words.get(i));
                    return;
                }
            }
        }
        System.out.println("GOOD SET");
    }*/

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        NoPrefixSet.noPrefix(words);

        bufferedReader.close();
    }
}
