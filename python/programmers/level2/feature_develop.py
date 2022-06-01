"""
https://programmers.co.kr/learn/courses/30/lessons/42586
"""


def solution(progresses, speeds):
    answer = []
    progresses.reverse()
    speeds.reverse()

    while len(progresses) > 0:
        for i in range(len(progresses) - 1, -1, -1):
            if progresses[i] < 100:
                progresses[i] += speeds[i]

        cnt = 0
        while len(progresses) > 0 and progresses[-1] >= 100:
            progresses.pop()
            cnt += 1

        if cnt > 0:
            answer.append(cnt)

    return answer

print(solution([93, 30, 55], [1, 30, 5]))
