"""
https://programmers.co.kr/learn/courses/30/lessons/42840/solution_groups?language=python3

파이썬에서 idx와 값을 모두 포함시켜 순회하는 법 enumerate()
"""

def solution(answers):
    answer = []
    p1 = [1, 2, 3, 4, 5]
    p2 = [2, 1, 2, 3, 2, 4, 2, 5]
    p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    scores = [0] * 3

    for i, ans in enumerate(answers):
        if p1[i % len(p1)] == ans:
            scores[0] += 1
        if p2[i % len(p2)] == ans:
            scores[1] += 1
        if p3[i % len(p3)] == ans:
            scores[2] += 1

    max_score = max(scores)
    for i, score in enumerate(scores):
        if score == max_score:
            answer.append(i + 1)

    return answer


print(solution([1,2,3,4,5]))