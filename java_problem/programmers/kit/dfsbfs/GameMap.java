package programmers.kit.dfsbfs;

// 게임 맵 최단거리
// 0,0 에서 시작해서 n, m 까지 가는 최단거리 구하기
// 11:53-12:19 (정확성 통과, 효율성 실패)
public class GameMap {
    public static void main(String[] args) {
        GameMap problem = new GameMap();

        int[][] maps = new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println("result : " + problem.solution(maps));

        maps = new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        System.out.println("result : " + problem.solution(maps));
    }

    public int solution(int[][] maps) {
        min = Integer.MAX_VALUE;
        maps[0][0] = 0;
        dfs(maps, 0, 0, 1);
        maps[0][0] = 1;
        return min==Integer.MAX_VALUE?-1:min;
    }

    int min;
    void dfs(int[][] maps, int currentY, int currentX, int cnt) {
        if (min<=cnt) {
            return;
        }
        if (currentY==maps.length-1 && currentX==maps[0].length-1 && min>cnt) {
            min = cnt;
            return;
        }

        if (currentX+1<maps[0].length && maps[currentY][currentX+1] == 1) {
            maps[currentY][currentX+1] = 0;
            dfs(maps, currentY, currentX+1, cnt+1);
            maps[currentY][currentX+1] = 1;
        }
        if (currentX-1>=0 && maps[currentY][currentX-1] == 1) {
            maps[currentY][currentX-1] = 0;
            dfs(maps, currentY, currentX-1, cnt+1);
            maps[currentY][currentX-1] = 1;
        }
        if (currentY+1<maps.length && maps[currentY+1][currentX] == 1) {
            maps[currentY+1][currentX] = 0;
            dfs(maps, currentY+1, currentX, cnt+1);
            maps[currentY+1][currentX] = 1;
        }
        if (currentY-1>=0 && maps[currentY-1][currentX] == 1) {
            maps[currentY-1][currentX] = 0;
            dfs(maps, currentY-1, currentX, cnt+1);
            maps[currentY-1][currentX] = 1;
        }
    }
}
