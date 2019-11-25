package practice.alg.strings;

import java.io.*;
import java.util.*;

/*
 * Problem:
 * �ϳ��� ���ڿ�(String)�� �־��� ���ε�, �ݺ��Ǵ� 2���� ���ڷ� �̷���� ���ڿ�(two alternating characters)�� 
 * �� ������ ���ڵ��� �ϳ��� �����ؾ� �Ѵ�. ������ �� �ִ� ����� ��� ����� �߿� ���ڿ��� ���� �� ���� ã�� ���� �����̴�.
 * 
 * Example:
 * in : abaacdabd 
 * ������ out : bcdbd (a �������� ��)
 * ������ out : bdbd (a�� c�� �������� ��)
 * ���� �� : 4
 * �׷���, ���� bdbd ó�� �ݺ��Ǵ� ���°� ������ �ʴ� ��� ���� ���� 0�� ��½�Ų��.
 * 
 * Constraints
 * 1 <= s���� <= 1000
 * 
 * Example:
 * in[0] : 10
 * in[1] : beabeefeab
 * ������ out : babab (b�� f�� �������� ��)
 * ������ out : bebeeeb (a�� f�� �������� ��)
 * ���� �� : 5
 * a�� f�� ������ ��쿡���� �ݺ��Ǵ� ���°� ������ �����Ƿ� �������� ���� out���� ���н��Ѽ� ����ؾ��Ѵ�.
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
