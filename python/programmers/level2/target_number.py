"""
https://programmers.co.kr/learn/courses/30/lessons/43165?language=python3

itertools.product(iter) : 데카르트 곱
활용 : n 개의 리스트가 존재할 때 n 개의 리스트에서 각각 하나씩 원소를 뽑아 만든 순서쌍을 반환한다
"""

answer = 0

def sol1(numbers, target):
    from itertools import product
    foo = [(x, -x) for x in numbers]
    print(list(product(*foo)))



def dfs(numbers, target, dep, result):
    if dep == len(numbers):
        if result == target:
            global answer
            answer += 1
    else:
        dfs(numbers, target, dep + 1, result + numbers[dep])
        dfs(numbers, target, dep + 1, result - numbers[dep])

def solution(numbers, target):
    dfs(numbers, target, 0, 0)
    return answer

sol1([1, 1, 1, 1, 1], 3)
print(answer)
