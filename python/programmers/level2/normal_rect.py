"""
https://programmers.co.kr/learn/courses/30/lessons/62048
"""
import math


def solution(w, h):
    gcd = math.gcd(w, h)
    n1 = max(w, h) // gcd
    n2 = min(w, h) // gcd
    linear_func = lambda x: (n1 / n2) * x

    cant_use = 0
    for i in range(n2):
        cant_use += math.ceil(linear_func(i + 1)) - math.floor(linear_func(i))

    return w * h - cant_use * (min(w, h) // n2)

print(solution(27, 2))
