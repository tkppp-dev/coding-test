from heapq import *

INF = int(1e9)
n, m, start = map(int, input().split())

# graph init
graph = [[] for i in range(n + 1)]

for _ in range(m):
    _from, to, duration = map(int, input().split())
    graph[_from].append((duration, to))

distance = [INF] * (n + 1)


def dijkstra(start):
    pq = []
    heappush(pq, (0, start))
    distance[start] = 0

    while pq:
        dist, now = heappop(pq)
        # 이미 처리한 요소면 컨티뉴
        if dist > distance[now]:
            continue
        else:
            for vertex in graph[now]:
                cost = dist + vertex[0]
                if cost < distance[vertex[1]]:
                    distance[vertex[1]] = cost
                    heappush(pq, (cost, vertex[1]))


dijkstra(start)
count = 0
max_dist = 0

for dist in distance:
    if dist < INF:
        count += 1
        max_dist = max(max_dist, dist)

print(count - 1, max_dist)
