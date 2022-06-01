"""
다른 풀이
단어의 개수를 세는 collections.Counter 객체를 이용함
Counter 객체끼리는 - 연산이 가능

list(Counter) 시 key 값만 반환

"""
from itertools import zip_longest
from collections import Counter

def sol1(participant, completion):
    answer = Counter(participant) - Counter(completion)

    return list(answer)[0]

def solution(participant, completion):
    answer = ''
    participant.sort()
    completion.sort()

    for p, c in zip_longest(participant, completion, fillvalue=-1):
        if p != c:
            answer = p
            break

    return answer

sol1(["leo", "kiki", "eden"], ["eden", "kiki"])


