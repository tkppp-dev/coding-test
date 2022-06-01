import sys

input = sys.stdin.readline

n, k = map(int, input().split(' '))
things = []

for _ in range(n):
    w, v = map(int, input().split(' '))
    things.append((w, v))

dp = [[0] * (k + 1) for _ in range(n)]

for i in range(1, k + 1):
    for j in range(n):
        w, v = things[j]
        dp[j][i] = max(dp[j - 1][i] if j - 1 >= 0 else 0,
                       0 if i - w < 0 else v + (dp[j - 1][i - w] if j - 1 >= 0 else 0))

print(dp[n-1][k])