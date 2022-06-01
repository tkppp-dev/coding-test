import sys
from heapq import heappop, heappush

input = sys.stdin.readline
INF = sys.maxsize

n, e = map(int, input().split(' '))
graph = {i: [] for i in range(1, n + 1)}

for _ in range(e):
    u, v, w = map(int, input().split(' '))
    graph[u].append((w, v))
    graph[v].append((w, u))

v1, v2 = map(int, input().split(' '))

def dijkstra(start):
    distance = [INF] * (n + 1)
    distance[start] = 0
    pq = [(0, start)]

    while pq:
        dist, now = heappop(pq)
        if dist > distance[now]:
            continue

        for w, next in graph[now]:
            cost = dist + w
            if cost < distance[next]:
                distance[next] = cost
                heappush(pq, (cost, next))

    return distance

path_at_v1 = dijkstra(v1)
path_at_v2 = dijkstra(v2)
middle = path_at_v1[v2]

if (path_at_v1[n] == INF and path_at_v1[n] == INF) or middle == INF:
    print(-1)
else:
    path1 = path_at_v1[1] + middle + path_at_v2[n]
    path2 = path_at_v2[1] + middle + path_at_v1[n]
    print(min(path1, path2))
