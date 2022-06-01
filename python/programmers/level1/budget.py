"""
https://programmers.co.kr/learn/courses/30/lessons/12982
"""

def solution(d, budget):
    answer = 0
    d.sort()

    for i in range(len(d)):
        if budget - d[i] < 0:
            break
        else:
            budget -= d[i]
            answer += 1
    return answer