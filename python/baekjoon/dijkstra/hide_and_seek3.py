"""
완전 탐색 유형의 문제는 BFS와 DFS를 사용
But, BFS와 DFS는 모든 간선의 가중치가 동일하다는 전제하에서 사용

이 문제는 순간이동과 걷기의 가중치가 다르기 때문에
1. 인접 리스트를 만들어 다익스트라자 사용하기  => 가능은 하나 무조건 3 * log100000 의 시간 복잡도를 가짐
2. Deque를 사용해 가중치가 0이면 앞에 삽입, 가중치가 1이면 뒤에 삽입하는 방식으로 BFS
"""
from heapq import heappush, heappop
from collections import deque

INF = int(1e9)
max_size = 100000
n, k = map(int, input().split(' '))

def dijkstra():
    graph = {i: [] for i in range(max_size + 1)}

    # create graph
    for vertex in graph:
        if vertex * 2 <= max_size:
            graph[vertex].append((0, vertex * 2))
        if vertex > 0:
            graph[vertex].append((1, vertex - 1))
        if vertex < max_size:
            graph[vertex].append((1, vertex + 1))

    pq = [(0, n)]
    duration = [INF] * (max_size + 1)
    duration[n] = 0

    while pq:
        time, cur_loc = heappop(pq)
        if time > duration[cur_loc]:
            continue

        for t, next_loc in graph[cur_loc]:
            dur = time + t
            if dur < duration[next_loc]:
                duration[next_loc] = dur
                heappush(pq, (dur, next_loc))

    print(duration[k])


def bfs_deque():
    dq = deque()
    answer = [0] * (max_size + 1)

    dq.append(n)
    visited = {n}
    while dq:
        now = dq.popleft()
        print(answer[0:16], dq, now)
        if now == k:
            return answer[now]

        if now * 2 <= max_size and now * 2 not in visited:
            dq.appendleft(now * 2)
            visited.add(now * 2)
            answer[now * 2] = answer[now]

        if now + 1 <= k and now + 1 not in visited:
            dq.append(now + 1)
            visited.add(now + 1)
            answer[now + 1] = answer[now] + 1

        if now - 1 >= 0 and now - 1 not in visited:
            dq.append(now - 1)
            visited.add(now - 1)
            answer[now - 1] = answer[now] + 1

print(bfs_deque())
