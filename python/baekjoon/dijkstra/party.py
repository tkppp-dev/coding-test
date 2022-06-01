"""
다익스트라 알고리즘을 돌렸을 때 결과는 v1 에서 다른 정점까지의 최단거리
여기서 역방향 그래프의 다익스트라 알고리즘의 결과는 다른 정점에서 v1까지의 최단거리이다.
"""

import sys
from heapq import heappush, heappop

INF = sys.maxsize
input = sys.stdin.readline

def dijkstra(graph, start, n):
    pq = []
    duration = [INF] * (n + 1)
    duration[start] = 0
    heappush(pq, (0, start))

    while pq:
        dur, now = heappop(pq)
        if dur > duration[now]:
            continue

        for d, to in graph[now]:
            temp = dur + d
            if temp < duration[to]:
                duration[to] = temp
                heappush(pq, (temp, to))

    return duration[1:]


def solution():
    n, m, x = map(int, input().split(' '))
    graph = [[] for _ in range(n + 1)]
    rev_graph = [[] for _ in range(n + 1)]

    for _ in range(m):
        _from, to, t = map(int, input().split(' '))
        graph[_from].append((t, to))
        rev_graph[to].append((t, _from))

    go = dijkstra(rev_graph, x, n)
    come = dijkstra(graph, x, n)

    print(max(map(lambda i: go[i] + come[i], range(len(go)))))

solution()

"""
4 8 4
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3
"""
