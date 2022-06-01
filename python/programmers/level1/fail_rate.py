"""
https://programmers.co.kr/learn/courses/30/lessons/42889

배워가는 것

sorted를 이용해 딕셔너리를 소팅할 때 유의점
sorted의 첫번째 인자로 딕셔너리 자체를 넣는다면 정렬된 결과의 key값 리스트가 반환됨
dict.items()를 넣어준다면 정렬된 딕셔너리를 반환
"""

from collections import Counter

def solution(N, stages):
    count = dict(Counter(stages))
    fail_rate = {}

    clear = len(stages)
    for i in range(1, N+1):
        if clear > 0:
            not_clear = count[i] if i in count else 0
            fail_rate[i] = not_clear/clear
            clear -= not_clear
        else:
            fail_rate[i] = 0

    return sorted(fail_rate, key=lambda x: -fail_rate[x])

print(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]))
