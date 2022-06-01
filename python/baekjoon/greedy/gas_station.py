n = int(input())
dist = list(map(int, input().split(' ')))
cost = list(map(int, input().split(' ')))

cur_cost = cost[0]
answer = cur_cost * dist[0]
for i in range(1, len(dist)):
    if cost[i] < cur_cost:
        cur_cost = cost[i]
    answer += cur_cost * dist[i]

print(answer)
