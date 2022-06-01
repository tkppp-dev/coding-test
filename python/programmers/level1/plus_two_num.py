"""
https://programmers.co.kr/learn/courses/30/lessons/68644/solution_groups?language=python3

다른 자료구조(set, dict)를 리스트로 변환하고 소팅해야 되는 경우
sorted(list(dataStructure)) 하면 불필요한 코드 줄일 수 있음
"""
from itertools import combinations

def solution(numbers):
    answer = set()
    combi = combinations(numbers, 2)
    for a, b in combi:
        answer.add(a + b)

    return sorted(list(answer))
