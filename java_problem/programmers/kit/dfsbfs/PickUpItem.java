package programmers.kit.dfsbfs;

// 미해결..
public class PickUpItem {
    class Solution {
        boolean[][] map = new boolean[50][50]; // 마지막 49행, 49열은 사용하지 않음
        char[] arrow = new char[2];

        void initialize(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            // 맵 색칠하기
            for (int y=0; y<50; y++) {
                for (int x=0; x<50; x++) {
                    if (map[y][x])
                        continue;

                    for (int i=0; i<rectangle.length; i++) {
                        if (rectangle[i][0]<=x && x<rectangle[i][2] && rectangle[i][1]<=y && y<rectangle[i][3])
                            map[y][x] = true;
                    }
                }
            }

            // 두 방향 찾기
            int i=0;
            if (map[characterY-1][characterX] != map[characterY-1][characterX-1]) {
                arrow[i++] = 'D'; // 아랫 방향
            }
            if (map[characterY][characterX] != map[characterY][characterX-1]) {
                arrow[i++] = 'U'; // 윗 방향
            }
            if (map[characterY-1][characterX-1] != map[characterY][characterX-1]) {
                arrow[i++] = 'L'; // 왼쪽 방향
            }
            if (map[characterY-1][characterX] != map[characterY][characterX]) {
                arrow[i++] = 'R'; // 오른쪽 방향
            }
        }

        void printMap() {
            for (int y=0; y<50; y++) {
                for (int x = 0; x < 50; x++) {
                    System.out.print(map[y][x]?1:'-');
                }
                System.out.println();
            }
        }

        void start() {

        }
    }

    public static void main(String[] args) {
        PickUpItem problem = new PickUpItem();

        int[][] rectangle = new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;
        System.out.println("result : " + problem.solution(rectangle, characterX, characterY, itemX, itemY));

//        rectangle = new int[][]{{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}};
//        characterX = 9;
//        characterY = 7;
//        itemX = 6;
//        itemY = 1;
//        System.out.println("result : " + problem.solution(rectangle, characterX, characterY, itemX, itemY));
//
//        rectangle = new int[][]{{1,1,5,7}};
//        characterX = 1;
//        characterY = 4;
//        itemX = 7;
//        itemY = 9;
//        System.out.println("result : " + problem.solution(rectangle, characterX, characterY, itemX, itemY));
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        Solution sol = new Solution();
        sol.initialize(rectangle, characterX, characterY, itemX, itemY);
        sol.printMap();

        // 두갈래 방향 구하기

        // 두갈래 각 진행
        //  진행방향에서 오른쪽부터 왼쪽으로 반원..
        //  진행방향 위쪽 경우) 오른쪽/위쪽/왼쪽 순서로 먼저 마주친 방향으로 이동한다.
        //  진행방향 왼쪽 경우) 위쪽/왼쪽/아래쪽 순서로 먼저 마주친 방향으로 이동한다.
        //  진행방향에서 왼쪽부터 오른쪽으로 반원..
        //  진행방향 위쪽 경우) 왼쪽/위쪽/오른쪽..
        //  진행방향 왼쪽 경우) 아래쪽/왼쪽/위쪽..

        // 2. 아래/왼쪽/위/오른쪽 순서로 먼저 마주친 방향으로 이동한다.
        // 최단 거리 둘레 구하기
//        int rangeX0 = Math.min(characterX, itemX);
//        int rangeX1 = Math.max(characterX, itemX);
//        int rangeY0 = Math.min(characterY, itemY);
//        int rangeY1 = Math.max(characterY, itemY);
//
//        // 1. 가로 방향
//        int w = 0;
//        for (int y=0; y<50; y++) {
//            boolean prev = false;
//            if (y<rangeY0) {
//                continue;
//            }
//            if (rangeY1<=y) {
//                break;
//            }
//            for (int x = 0; x < 50; x++) {
//                if (x<rangeX0) {
//                    continue;
//                }
//                if (rangeX1<=x) {
////                    System.out.println("w : " + w);
//                    break;
//                }
//                if (prev != map[y][x]) {
//                    w++;
//                    prev = map[y][x];
//                }
//            }
//        }
//
//        // 2. 세로 방향
//        int h = 0;
//        for (int x=0; x<50; x++) {
//            boolean prev = true;
//            if (x<rangeX0) {
//                continue;
//            }
//            if (rangeX1<=x) {
//                break;
//            }
//            for (int y = 0; y < 50; y++) {
//                if (y<rangeY0) {
//                    continue;
//                }
//                if (prev != map[y][x]) {
//                    h++;
//                    prev = map[y][x];
//                }
//                if (rangeY1<=y) {
////                    System.out.println("h : " + h);
//                    break;
//                }
//            }
//        }

        // debug

        return 0;
    }
}
