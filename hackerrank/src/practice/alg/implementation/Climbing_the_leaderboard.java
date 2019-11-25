package practice.alg.implementation;

import java.io.*;
import java.util.*;

/*
 * Problem: 
 * Alice는 오락실 게임(arcade game)의 명단(leaderboard)에 오르기를 원한다. 그리고 자신의 랭킹을 추적하기를 원한다.
 * 이 게임은 "Dense Ranking"을 사용한다.
 * 
 * "Dense Ranking"이란, 같은 점수에 대해서는 같은 랭킹을 주는 것이다. 예를 들어, 4명의 player가 각각 100, 90, 90, 80점을
 * 받았다면, 각각 1등, 2등, 2등, 3등인 것이다. 그 뒤로 Alice가 70점, 80점, 105점을 받았다면, 4등, 3등, 1등이 될 것이다.
 * 
 * Input:
 * n, score[i] (명단에 n회에 대한 score들이 기록되어 있다.)
 * m, alice[j] (Alice는 m회 게임에 대한 alice점수들이 기록될 것이다.)
 * 
 * Example:
 * 7, [100, 100, 50, 40, 40, 20, 10]
 * 4, [5, 25, 50, 120]
 * 최종 결과값 : 6, 4, 2, 1
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
