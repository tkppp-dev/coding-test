from sys import *
from heapq import *

def solution():
    INF = maxsize
    N = int(stdin.readline())
    M = int(stdin.readline())
    graph = {i: [] for i in range(1, N + 1)}

    for _ in range(M):
        _from, to, w = map(int, stdin.readline().split(' '))
        graph[_from].append((w, to))

    dept, dest = map(int, stdin.readline().split(' '))
    distance = [INF] * (N + 1)
    pq = []
    heappush(pq, (0, dept))

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
    print(distance[dest])

solution()
