"""
최단 거리 => 앵각하면 bfs 또는 다익스트라자(벨만-포드)일 확률 높음
플로이드-워셜은 n^3 이기 때문

안되는걸 되게하는데 이 중 최소로 하게 하려 한다 => 최단 거리 느낌
1. 안되는것(벽)을 가중치를 가진 다익스트라자로 생각
2. 우선순위큐 + bfs 조합으로 되게하는 단계를 우선순위로 잡고 안되는것을 만났을때 단계를 올려서 우선순위 큐에 삽입하는 방식
"""

import sys
from heapq import heappush, heappop

INF = sys.maxsize
input = sys.stdin.readline

n = int(input())
maze = [[int(i) for i in input()[:-1]] for _ in range(n)]

# 상하좌우
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]


def dijkstra():
    distance = [[INF] * n for _ in range(n)]
    distance[0][0] = 0

    pq = [(0, 0, 0)]
    while pq:
        dist, row, col = heappop(pq)
        if dist > distance[row][col]:
            continue

        for i in range(4):
            n_row = row + dy[i]
            n_col = col + dx[i]
            if 0 <= n_row < n and 0 <= n_col < n:
                w = 0 if maze[n_row][n_col] else 1
                cost = dist + w
                if cost < distance[n_row][n_col]:
                    distance[n_row][n_col] = cost
                    heappush(pq, (cost, n_row, n_col))
    return distance[n - 1][n - 1]


def bfs():
    pq = [(0, 0, 0)]
    visited = {(0, 0)}

    while pq:
        count, row, col = heappop(pq)

        if row == n - 1 and col == n - 1:
            return count

        for i in range(4):
            n_row = row + dy[i]
            n_col = col + dx[i]
            if 0 <= n_row < n and 0 <= n_col < n and (n_row, n_col) not in visited:
                visited.add((n_row, n_col))
                if maze[n_row][n_col] == 1:
                    heappush(pq, (count, n_row, n_col))
                else:
                    heappush(pq, (count + 1, n_row, n_col))


print(dijkstra())
print(bfs())
