package practice.data.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    	List<Integer> result = new ArrayList<Integer>();
    	
    	List<List<Integer>> tmpList = new ArrayList<List<Integer>>();
    	for(int i=0; i<n; i++) {
    		tmpList.add(new ArrayList<Integer>());
    	}
    	
    	int lastAnswer = 0;
    	for(int i=0; i<queries.size(); i++) {
    		List<Integer> list = queries.get(i);
    		int x = list.get(1);
    		int y = list.get(2);
    		
    		if(list.get(0) == 1) {
    			int seq = (x^lastAnswer)%n;
    			tmpList.get(seq).add(y);
    		}
    		else if(list.get(0) == 2) {
    			int seq = (x^lastAnswer)%n;
    			int size = tmpList.get(seq).size();
    			lastAnswer = tmpList.get(seq).get(y%size);
    			result.add(lastAnswer);
    		}
    		else
    			continue;
    	}
		return result;
    }

}

/*
 * Task N, Q
 * 
 * query type 1 x y : (x^lastAnswer) % N = seq => index
 * query type 2 x y : (x^lastAnswer) % N = seq => y%seq's size => lastAnwer (print)
 * 
 * input 	lastAnswer	S[0]	s[1]
 * 	2 5		0			-		-
 * 	1 0 5	0			5		-
 * 	1 1 7	0			5		7
 * 	1 0 3	0			5 3		7
 * 	2 1 0	0			5 3		7	(print)
 *  2 1 1	7			5 3 	7	(print)
 *  		3			5 3		7
 * output :
 *  7
 *  3
 */

public class Dynamic_Array {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<Integer> result = Result.dynamicArray(n, queries);

        for (int i = 0; i < result.size(); i++) {
//            bufferedWriter.write(String.valueOf(result.get(i)));
        	System.out.print(result.get(i));
            if (i != result.size() - 1) {
//                bufferedWriter.write("\n");
            	System.out.println();
            }
        }

//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
