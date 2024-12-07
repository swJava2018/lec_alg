package hackerrank.interviewPreparation;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

// 봄버맨 문제 (Basic)
// 정확도 통과, 시간 타임 초과

public class Bomberman {
    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    public static List<String> bomberMan(int n, List<String> grid) {
        // Write your code here

        // 초 : 작업
        // 0 : 랜덤값으로 폭탄 세팅
        // 1 : 봄버맨은 아무것도 하지 않음
        // 2 : 봄버맨은 설치되지 않은 위치에 모두 폭탄을 설치
        // 3 : 폭탄 터짐
        // (2~3초 사이의 작업이 무한 반복딤)

        // 0초 or 1초일 경우, 초기 폭탄 Map 그대로 반환
        if (n < 2) {
            return grid;
        }

        // 2초 이상일 경우, string Map -> bool Map 변환 (false: 폭탄 없음, true: 폭탄 있음)
        boolean[][] map = new boolean[grid.size()][grid.get(0).length()];
        for (int i=0; i<grid.size(); i++) {
            for (int j=0; j<grid.get(0).length(); j++) {
                map[i][j] = grid.get(i).charAt(j) == 79; // 'O' 값일 경우 폭탄이 존재함
            }
        }

//        printMap(map);

        // 짝수초 후에는, 항상 모든 위치에 폭탄이 설치되므로, 모두 채워서 바로 반환
        boolean isFull = n%2 == 0;
        if (isFull) {
            List<String> result = new ArrayList<>();
            for (int i=0; i<grid.size(); i++) {
                String str = "";
                for (int j = 0; j < grid.get(0).length(); j++) {
                    str += 'O';
                }
                result.add(str);
            }
            return result;
        }

        boolean[][] prevMap = new boolean[grid.size()][grid.get(0).length()];
        int loopCnt = n/2;
        // 홀수초 후에는,
        for (int k=0; k<loopCnt; k++) {
            for (int i=0; i<grid.size(); i++) {
                for (int j=0; j<grid.get(0).length(); j++) {
                    // 이전 위치 스냅샷
                    prevMap[i][j] = map[i][j];

                    // map 반전
                    map[i][j] = !map[i][j];
                }
            }
            for (int i=0; i<grid.size(); i++) {
                for (int j=0; j<grid.get(0).length(); j++) {
                    // 이전 위치 스냡샷에서 폭탄이 있는 곳의 상하좌우 값을 폭탄이 없는 상태로 변경
                    if (prevMap[i][j]) {
                        // 상
                        if (i-1>=0) map[i-1][j] = false;
                        // 하
                        if (i+1<grid.size()) map[i+1][j] = false;
                        // 좌
                        if (j-1>=0) map[i][j-1] = false;
                        // 우
                        if (j+1<grid.get(0).length()) map[i][j+1] = false;
                    }
                }
            }
        }

//        printMap(map);

        // 문자열 배열로 변환
        List<String> result = new ArrayList<>();
        for (int i=0; i<grid.size(); i++) {
            String str = "";
            for (int j = 0; j < grid.get(0).length(); j++) {
                str += map[i][j]?'O':'.';
            }
            result.add(str);
        }
        return result;
    }

    static void printMap(boolean[][] map) {
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[0].length; j++) {
                System.out.printf("%d", map[i][j]==true?1:0);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
                try {
                    return bufferedReader.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
            .collect(toList());

        List<String> result = bomberMan(n, grid);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
                + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
