/*************************************************
 ** 다익스트라 최단 경로 프로그램

 0번째 노드에서 각 모든 노드로 갈 수 있는 최단거리를 즉정하는 알고리즘 
 https://mattlee.tistory.com/50
*************************************************/
 
#include <stdio.h>
 
#define INT_MAX 2147483647 // 최대 정수
#define TRUE 1
#define FALSE 0
#define MAX_VERTICES 7  // 정점의 수
#define INF 1000    // 무한대 (연결이 없는 경우)
 
int weight[MAX_VERTICES][MAX_VERTICES] = {
  {0,7,INF,INF,3,10,INF},
  {7,0,4,10,2,6,INF},
  {INF,4,0,2,INF,INF,INF},
  {INF,10,2,0,11,9,4},
  {3,2,INF,11,0,INF,5},
  {10,6,INF,9,INF,0,INF},
  {INF,INF,INF,4,5,INF,0}
};
 
int distance[MAX_VERTICES]; // 시작 정점으로부터의 최단 경로 거리
int found[MAX_VERTICES];  // 방문한 정점 표시
 
int choose(int distance[], int n, int found[])
{
  int i, min, minpos;
  min = INT_MAX;
  minpos = -1;
 
  // (가장 작은 거리르르 가진) 다시는 방문하지 않을 확정 노드
  for (i = 0; i < n; i++) {
    if (distance[i] < min && found[i] == FALSE) {
      min = distance[i];
      minpos = i;
    }
  }
  return minpos;
}
 
// start 노드부터 n번 노드까지 최단거리 모두 측정 
void shortest_path(int start, int n)
{
  // start 번째 노드 방문
  int i, u, w;
  for (i = 0; i < n; i++) {
    distance[i] = weight[start][i];
    found[i] = FALSE;
  }
  found[start] = TRUE; // 방문 체크
  distance[start] = TRUE;
 
  // start 번째 노드의 다음 노드들 하나씩 방문 
  for (i = 0; i < n - 1; i++) {
    u = choose(distance, n, found); // 핵심@@@
    found[u] = TRUE; // 방문 체크 (가장 작은 거리만)
    
    for (w = 0; w < n; w++) {
      if (found[w] == FALSE) { // 방문하지 않은 나머지는 
        if (distance[u] + weight[u][w] < distance[w]) {
          // (가장 작은 거리인) 방문 거리와 (거기를 거쳐서 돌아갈때) 다음 거리의 합이 더 작다면
          distance[w] = distance[u] + weight[u][w]; 
        }
      }
    }
  }

  // 0 노드부터 모든 노드까지 최단거리 출력 
  for(i=0; i < n; i++)
    printf("%d ", distance[i]);
}
 
void main()
{
  shortest_path(0, MAX_VERTICES);
}
/*************************************************
 ** End Line
*************************************************/