"""
다익스트라자 + 서로소 집합 => x 에서 모든 노드까지 최단경로로 신장트리를 만드는 것
따라서 간선의 개수는 정점의 개수 - 1 일 수 밖에
"""

import sys
from heapq import heappush, heappop

INF = sys.maxsize
input = sys.stdin.readline

n, m = map(int, input().split(' '))
graph = {i: [] for i in range(n + 1)}
parents = [i for i in range(n + 1)]
for _ in range(m):
    u, v, s = map(int, input().split(' '))
    graph[u].append((s, v))
    graph[v].append((s, u))

times = [INF] * (n + 1)
times[1] = 0
pq = [(0, 1)]

while pq:
    time, now = heappop(pq)
    if time > times[now]:
        continue

    for s, next in graph[now]:
        dur = time + s
        if dur < times[next]:
            parents[next] = now
            times[next] = dur
            heappush(pq, (dur, next))

print(n-1)
for i in range(2, n+1):
    print(i, parents[i])
