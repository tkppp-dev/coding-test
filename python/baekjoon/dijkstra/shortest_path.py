from sys import stdin
from heapq import *
INF = int(1e9)

def dijkstra(graph, start, n):
    distance = [INF] * (n + 1)
    pq = []
    heappush(pq, (0, start))

    while pq:
        dist, now = heappop(pq)
        if dist > distance[now]:
            continue
        else:
            for weight, to in graph[now]:
                cost = dist + weight
                if cost < distance[to]:
                    distance[to] = cost
                    heappush(pq, (cost, to))

    return distance

if __name__ == '__main__':
    v, e = map(int, stdin.readline().split(' '))
    start = int(stdin.readline())
    graph = {i: [] for i in range(1, v + 1)}

    for i in range(e):
        u, to, w = map(int, stdin.readline().split(' '))
        graph[u].append((w, to))

    answer = dijkstra(graph, start, v)
    for i in range(1, v + 1):
        if i == start:
            print(0)
        else:
            print(answer[i] if answer[i] != INF else 'INF')

