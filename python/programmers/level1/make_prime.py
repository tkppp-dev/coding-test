"""
https://programmers.co.kr/learn/courses/30/lessons/12977

알아가는 것
for - else
for 문이 break 로 중단된 것이 아니라면 else 구문을 실행시키는 파이썬 특이점
"""

from itertools import combinations

def is_prime(n):
    for i in range(2, n // 2 + 1):
        if n % i == 0:
            return 0
    return 1

def solution(nums):
    answer = 0
    for a, b, c in combinations(nums, 3):
        answer += is_prime(a + b + c)

    return answer
