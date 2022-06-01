"""
https://programmers.co.kr/learn/courses/30/lessons/72411
방향성이랑 풀이 완벽쓰
다만 Counter 객체, combinations 사용법 숙지 필요

Counter
    1. 가장 빈도수가 높은 원소만 반환하는 메소드는 존재하지 않음
    2. most_common() 메소드로 전체에서 순회하며 빈도수가 높은 것을 뽑아내야함

combinations()
    1. 전체 원소의 개수보다 큰 개수의 조합을 뽑으려해도 오류가 발생하지 않고 빈 리스트를 반환한다

리스트 내포를 filter 처럼 사용 가능함
"""

from collections import Counter
from itertools import combinations


def solution(orders, course):
    answer = []

    for i in course:
        combi = []
        for order in orders:
            if len(order) >= i:
                combi += list(map(lambda x: ''.join(sorted(x)), combinations(order, i)))
        counter = list(Counter(combi).most_common())
        answer += [menus for menus, count in counter if count > 1 and count == counter[0][1]]

    return sorted(answer)

print(solution(["XYZ", "XWY", "WXA"], [2, 3, 4]))

