package practice.alg.implementation;

import java.io.*;
import java.util.*;

/*
 * Problem: 
 * Alice�� ������ ����(arcade game)�� ���(leaderboard)�� �����⸦ ���Ѵ�. �׸��� �ڽ��� ��ŷ�� �����ϱ⸦ ���Ѵ�.
 * �� ������ "Dense Ranking"�� ����Ѵ�.
 * 
 * "Dense Ranking"�̶�, ���� ������ ���ؼ��� ���� ��ŷ�� �ִ� ���̴�. ���� ���, 4���� player�� ���� 100, 90, 90, 80����
 * �޾Ҵٸ�, ���� 1��, 2��, 2��, 3���� ���̴�. �� �ڷ� Alice�� 70��, 80��, 105���� �޾Ҵٸ�, 4��, 3��, 1���� �� ���̴�.
 * 
 * Input:
 * n, score[i] (��ܿ� nȸ�� ���� score���� ��ϵǾ� �ִ�.)
 * m, alice[j] (Alice�� mȸ ���ӿ� ���� alice�������� ��ϵ� ���̴�.)
 * 
 * Example:
 * 7, [100, 100, 50, 40, 40, 20, 10]
 * 4, [5, 25, 50, 120]
 * ���� ����� : 6, 4, 2, 1
 */
public class Climbing_the_leaderboard {
	// Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] sf = new int[scores.length]; 
        int sf_len;
        
        // remove duplicated data
        int tmp = -1;              
        int i, j;
        for(i=0, j=0; i<scores.length; i++) {
            if(tmp != scores[i]) {
                sf[j] = scores[i];
                tmp = sf[j];
                //System.out.print(sf[j] + ", ");
                j++;
            }
        }
        sf_len = j;
        //System.out.println("len" + sf_len);
        
        // find rank
        int[] rank = new int[alice.length];
        i = 0;
        j = sf_len-1;
        while(i < alice.length) {
            if(j==0 && sf[j]<=alice[i]) {
                //System.out.println("rank.. " + (j+1));
                rank[i] = j+1;
                i++;                
            }
            else if(sf[j] > alice[i]) {
                //System.out.println("rank... " + (j+2));
                rank[i] = j+2;
                i++;
            }
            else if(sf[j] <= alice[i]) {
                j = j>0?j-1:j;
            }
        }
        
        return rank;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
