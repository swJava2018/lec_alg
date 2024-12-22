package hackerrank.interviewPreparation;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

// Prepare > Interview > Preparation Kits > 1 Month Preparation Kit > Week 4 > Lily's Homework
// 수준 : Intermediate / 성공률 (76.41%)
// 문제 : 주어진 배열(arr)의 숫자를 오름차순 or 내림차순으로 만들기 위한 최소로 교환해야하는 횟수 구하기
// 풀이 검사 : 테스트 일부 통과(정확도 통과, 시간 타임 초과)
// 풀이 접근 : DFS

// sample
//4
//7 15 12 3
//2 <-- 2번 교환 필요

// sample
//4
//2 5 3 1
//2 <-- 2번 교환 필요

public class LilyHomework {
    static List<Integer> sorted;
    static List<Integer> targetIdx;

    // key : 값, value : 값이 현재 위치해있는 index
    static int minDepth = Integer.MAX_VALUE;
    public static int dfs(int depth, List<Integer> arr) {
        // 일치하지 않는 값들 확인
        for (int i=0; i<arr.size(); i++) {
            // (알려진) 일치하는 값 패스
            if (arr.get(i).equals(sorted.get(i))) {
                continue;
            }

            // (일려지지 않은) 일치하지 않는 값이 일치하기 위해 이동해야하는 곳 확인
            // 이미 완료된 위치
            if (targetIdx.get(i).equals(-1)) {
                continue;
            }

            // target 교환
            int iTargetIdx = targetIdx.get(i);
            int iTargetOfTargetIdx = targetIdx.get(iTargetIdx);
            targetIdx.set(iTargetIdx, -1);
            if (iTargetOfTargetIdx == i) {
                targetIdx.set(i, -1);
            } else {
                targetIdx.set(i, iTargetOfTargetIdx);
            }

            // value 교환
            int valueI = arr.get(i);
            int valueOfValueI = arr.get(iTargetIdx);
            arr.set(i, valueOfValueI);
            arr.set(iTargetIdx, valueI);

            dfs(depth + 1, arr);

            // value 복구
            arr.set(i, valueI);
            arr.set(iTargetIdx, valueOfValueI);

            // target 복구
            targetIdx.set(i, iTargetIdx);
            targetIdx.set(iTargetIdx, iTargetOfTargetIdx);
        }

        // 모든 값이 정렬된 값으로 일치할 경우
        if (arr.equals(sorted) && targetIdx.stream().allMatch(value -> value == -1) && minDepth > depth) {
            minDepth = depth;
        }
        return minDepth;
    }

    public static int lilysHomework(List<Integer> arr) {
        sorted = new ArrayList<>(arr);
        Collections.sort(sorted);

        targetIdx = new ArrayList<>(arr.size());
        for (int i=0; i<arr.size(); i++) {
            targetIdx.add(-1);
            if (!sorted.get(i).equals(arr.get(i))) {
                for (int j=0; j<arr.size(); j++) {
                    if (sorted.get(j).equals(arr.get(i))) {
                        targetIdx.set(i, j);
                    }
                }
            }
        }
        int l0 = dfs(0, arr);

        sorted = new ArrayList<>(arr);
        Collections.sort(sorted, Comparator.reverseOrder());

        targetIdx = new ArrayList<>(arr.size());
        for (int i=0; i<arr.size(); i++) {
            targetIdx.add(-1);
            if (!sorted.get(i).equals(arr.get(i))) {
                for (int j=0; j<arr.size(); j++) {
                    if (sorted.get(j).equals(arr.get(i))) {
                        targetIdx.set(i, j);
                    }
                }
            }
        }
        int l1 = dfs(0, arr);
        return Math.min(l0, l1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = LilyHomework.lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
