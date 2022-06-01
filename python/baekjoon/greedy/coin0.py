import sys

input = sys.stdin.readline
n, k = map(int, input().split(' '))
coins = []
for _ in range(n):
    coin = int(input())
    if coin <= k:
        coins.append(coin)

coins.reverse()
answer = 0
i = 0
while k > 0:
    answer += k // coins[i]
    k %= coins[i]
    i += 1

print(answer)
