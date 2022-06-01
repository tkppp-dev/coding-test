"""
서로소 집합의 아이디어를 떠올려서 경로를 추적하도록 한것은 잘했다
스택을 이용한 추적방식도 공부해보자
zip으로 만든 그룹을 다시 zip을 사용해 unzip 할 수 있다
"""

from heapq import heappush, heappop
import sys

INF = sys.maxsize
input = sys.stdin.readline

n = int(input())
m = int(input())
graph = {i: [] for i in range(1, n + 1)}

for _ in range(m):
    u, v, w = map(int, input().split(' '))
    graph[u].append((w, v))

start, end = map(int, input().split(' '))
parents = [i for i in range(n + 1)]
costs = [INF] * (n + 1)
costs[start] = 0
pq = [(0, start)]

stack = [(0, start)]

while pq:
    cost, now = heappop(pq)
    if cost > costs[now]:
        continue

    for c, next in graph[now]:
        temp = c + cost
        if temp < costs[next]:
            costs[next] = temp
            parents[next] = now
            heappush(pq, (temp, next))
            while temp < stack[-1][0]:
                stack.pop()
            stack.append((temp, next))

x = end
path = []
while True:
    path.append(x)
    if parents[x] == x:
        break
    else:
        x = parents[x]
path.reverse()
print(path, list(zip(*stack))[1])
print(costs[end])
print(len(path))
for v in path:
    print(v, end=' ')
