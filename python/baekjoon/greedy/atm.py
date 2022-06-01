n = int(input())
duration = sorted(map(int, input().split(' ')))

total = 0
cur = 0
for x in duration:
    cur += x
    total += cur

print(total)
