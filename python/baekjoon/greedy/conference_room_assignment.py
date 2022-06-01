"""
그리디 유형중 정렬과 함께 사용하는 유형
시작 시간과 총 시간에 매몰되 완탐 밖에 답이 없어 보였으나
종료 시간을 기준으로 정렬하면 되었던 문제
"""

import sys

input = sys.stdin.readline
n = int(input())
memo = {}
times = []

for _ in range(n):
    s, e = map(int, input().split(' '))
    if s in memo:
        if s == e or s > memo[e]:
            times.append((e, s))
    else:
        times.append((e, s))

times.sort()
print(times)
answer = 1
end = times[0][0]
for e, s in times[1:]:
    if s < end:
        continue
    else:
        answer += 1
        end = e

print(answer)
