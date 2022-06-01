n = int(input())

i = 0
while n > 0 and n % 5 != 0:
    n -= 3
    i += 1

if n < 0:
    print(-1)
else:
    print(i + n // 5)
