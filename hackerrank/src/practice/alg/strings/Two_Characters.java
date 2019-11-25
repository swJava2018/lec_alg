package practice.alg.strings;

import java.io.*;
import java.util.*;

/*
 * Problem:
 * 하나의 문자열(String)이 주어질 것인데, 반복되는 2개의 문자로 이루어진 문자열(two alternating characters)이 
 * 될 때까지 문자들을 하나씩 제거해야 한다. 제거할 수 있는 기능한 모든 방법들 중에 문자열이 가장 긴 값을 찾는 것이 문제이다.
 * 
 * Example:
 * in : abaacdabd 
 * 가능한 out : bcdbd (a 제거했을 때)
 * 가능한 out : bdbd (a와 c를 제거했을 때)
 * 최종 값 : 4
 * 그런데, 만약 bdbd 처럼 반복되는 형태가 나오지 않는 경우 최종 값은 0을 출력시킨다.
 * 
 * Constraints
 * 1 <= s길이 <= 1000
 * 
 * Example:
 * in[0] : 10
 * in[1] : beabeefeab
 * 가능한 out : babab (b와 f를 제거했을 때)
 * 가능한 out : bebeeeb (a와 f를 제거했을 때)
 * 최종 값 : 5
 * a와 f를 제거한 경우에서는 반복되는 형태가 나오지 않으므로 가능하지 않은 out으로 구분시켜서 계산해야한다.
 */

public class Two_Characters {
	
	// Complete the alternate function below.
    static int alternate(String s) {

        if (s.length() == 2)
            return 2;

        HashMap<Character, Integer> map = new HashMap();

        // check isExist
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            map.put(c, s.indexOf(c));
        }

        int result = 0;

        // get 2 character
        Character[] carr = new Character[map.size()];
        map.keySet().toArray(carr);
        for (int i = 0; i < carr.length - 1; i++) {
            for (int j = i + 1; j < carr.length; j++) {
                String tmp = s;

                for (int k = 0; k < carr.length; k++) {
                    if (k != i && k != j) {
                        tmp = tmp.replaceAll(carr[k] + "", "");
                    }
                }

                // System.out.println(tmp);
                // check alternating

                int k = 0;
                for (k = 0; k < tmp.length(); k += 2) {
                    if (tmp.length() == k + 1) {
                        if (tmp.charAt(k) != tmp.charAt(0))
                            break;
                    }

                    else if (tmp.charAt(k) != tmp.charAt(0) || tmp.charAt(k + 1) != tmp.charAt(1))
                        break;
                }

                if (k >= tmp.length()) {
                    // System.out.println(tmp + " <-- alternating");
                    result = tmp.length() > result ? tmp.length() : result;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new
        FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);
        // System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
