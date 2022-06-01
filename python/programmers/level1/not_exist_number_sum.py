# https://programmers.co.kr/learn/courses/30/lessons/86051
"""
내 풀이: 클래식하게 체크 배열 만들고 순회하면서 체크 배열 안에 있는지 확인하고 다시 순회해서 답 구하기

Sol1
    빠진 수의 합은 0..9 까지의 합 - 주어진 배열의 합 이라는 아이디어 활용
Sol2
    굳이 체크 배열 만들지 않고 파이썬의 in 연산자를 활용하여 배열내 존재하는지 체크할 수 있다
"""

def sol1(numbers):
    return 45 - sum(numbers)

def sol2(numbers):
    answer = 0
    for i in range(0):
        if i not in numbers:
            answer += i
    return answer

def solution(numbers):
    answer = 0
    check = [0] * 10

    for n in numbers:
        if check[n] == 0:
            check[n] = 1

    for i in range(10):
        if check[i] == 0:
            answer += i

    return answer
