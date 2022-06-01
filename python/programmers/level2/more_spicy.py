"""
https://programmers.co.kr/learn/courses/30/lessons/42626
"""
from heapq import *

# 힙을 안쓴 풀이도 통과하나?
def sol1(scoveille, k):
    answer = 0
    scoveille.sort(reverse=True)

    while scoveille[-1] < k:
        answer += 1
        f1 = scoveille.pop()
        f2 = scoveille.pop() * 2
        scoveille.append(f1 + f2)
        scoveille.sort(reverse=True)
        if len(scoveille) == 1 and scoveille[0] < k:
            return -1

    return answer


def solution(scoville, k):
    answer = 0
    heapify(scoville)
    while scoville[0] < k:
        answer += 1
        f1 = heappop(scoville)
        f2 = heappop(scoville) * 2
        heappush(scoville, f1 + f2)
        if len(scoville) == 1 and scoville[0] < k:
            return -1

    return answer

solution([1, 2, 3, 9, 10, 12], 7)
