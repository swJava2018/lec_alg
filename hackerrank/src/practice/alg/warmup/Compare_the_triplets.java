package practice.alg.warmup;

import java.io.*;
import java.util.*;

/*
 * Problem :
 * Alice와 Bob은 시험문제를 풀어야 하는데, 주어진 시험은 아래의 3가지 카테고리를 가진다.
 * 투명성(clarity), 독창성(originality), 어려움(difficulty)
 * 
 * Rule :
 * a = (a[0], a[1], a[2])
 * b = (b[0], b[1], b[2])
 * 
 * if( a[i] > b[i] ) Alice는 1점이 추가된다.
 * if( a[i] < b[i] ) Bob는 1점이 추가된다.
 * if( a[i] = b[i] ) 아무도 점수를 가지지 않는다.
 * 
 * 1<=a[i]<=100
 * 1<=a[i]<=100
 * 
 * Example : 아래의 output은 [1,1]이다.
 * a = [1,2,3] 
 * b = [3,2,1]
 * 
 * Example : 아래의 output은 [1,1]이다.
 * a = [5,6,7]
 * b = [3,6,10]
 * 
 * Example : 아래의 output은 [2,1]이다.
 * a = [17,28,30]
 * b = [99,16,8]
 */

public class Compare_the_triplets {

	// Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int alice = 0;
        int bob = 0;
        for(int i = 0; i<a.size(); i++){
            if(a.get(i) > b.get(i)){
                alice++;
            }else if(a.get(i) < b.get(i)){
                bob++;
            }
        }
        List<Integer> arrayresult = new ArrayList<Integer>();
        arrayresult.add(alice);
        arrayresult.add(bob);
        return arrayresult;        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a.add(aItem);
        }

        String[] bItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int bItem = Integer.parseInt(bItems[i]);
            b.add(bItem);
        }

        List<Integer> result = compareTriplets(a, b);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
