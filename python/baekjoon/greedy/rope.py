"""
그리디라고 완탐을 무서워하지 말자
핵심적인 아이디어가 그리디이고 답을 구하는 과정에서 완탐 형식으로 들어갌수있다
결국 중요한 것은 시간복잡도
"""
import sys
input = sys.stdin.readline

n = int(input())
ropes = []
for _ in range(n):
    ropes.append(int(input()))

ropes.sort()
answer = []
for i in range(n):
    answer.append(ropes[i] * (n - i))

print(max(answer))
