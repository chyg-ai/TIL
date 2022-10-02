#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0
#define MAX_VERTICES 50

typedef struct GraphNode {
  int v; // 정점의 번호
  struct GraphNode *link;
} GraphNode;

typedef struct GraphType {
  int n;
  GraphNode *adj_list[MAX_VERTICES];
} GraphType;

int visited[MAX_VERTICES];

// 그래프 초기화
void init(GraphType *g) {
  g->n = 0;
  for (int i = 0; i < MAX_VERTICES; i++) {
    g->adj_list[i] = NULL;
  }
}

// 정점 추가
void insert_vertex(GraphType *g, int v) {
  if (((g->n) + 1) > MAX_VERTICES) {
    fprintf(stderr, "그래프: 정점의 개수 초과");
    return;
  }
  g->n++;
}

// 간선 추가
void insert_edge(GraphType *g, int start, int end) {
  if (start >= g->n || end >= g->n) {
    fprintf(stderr, "그래프: 정점 번호 오류");
    return;
  }

  GraphNode *node = (GraphNode *)malloc(sizeof(GraphNode));
  node->v = end;                   // 인접 정점의 번호 추가
  node->link = g->adj_list[start]; // 인접 정점 추가
  g->adj_list[start] = node;
}

// DFS 탐색
void dfs_list(GraphType *g, int v) {
  visited[v] = TRUE; // 방문 여부 표시
  printf("정점 %d -> ", v);

  for (GraphNode *w = g->adj_list[v]; w != NULL; w = w->link) {
    if (!visited[w->v]) {
      dfs_list(g, w->v);
    }
  }
}

int main(void) {
  GraphType *g;
  g = (GraphType *)malloc(sizeof(GraphType));
  init(g);
  for (int i = 0; i < 4; i++) {
    insert_vertex(g, i);
  }
  insert_edge(g, 0, 1);
  insert_edge(g, 0, 2);
  insert_edge(g, 0, 3);
  insert_edge(g, 1, 2);
  insert_edge(g, 2, 3);

  printf("깊이 우선 탐색\n");
  dfs_list(g, 0);
  printf("\n");
  free(g);
  return 0;
}