"""
두개의 우선순위 큐를 이용해 중간값을 구하는데 활용할 수 있다.
최대힙 - 중간 - 최소힙
"""
from heapq import heappush, heappop
import sys
input = sys.stdin.readline

n = int(input())
left = [-int(input())]
right = []
print(-left[0])

for _ in range(1, n):
    new = int(input())

    if len(left) == len(right):
        if new <= right[0]:
            heappush(left, -new)
        else:
            temp = heappop(right)
            heappush(left, -temp)
            heappush(right, new)
    elif len(left) > len(right):
        if new < -left[0]:
            temp = -heappop(left)
            heappush(left, -new)
            heappush(right, temp)
        else:
            heappush(right, new)
    else:
        heappush(left, -new)

    print(-left[0])

