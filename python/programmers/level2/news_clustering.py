"""
https://programmers.co.kr/learn/courses/30/lessons/17677

1. 파이썬의 참 거짓
아래의 경우를 제외하고는 객체는 항상 True
    1. 객체가 비어있는 경우 ex) [], (), {}
    2. 객체가 Falseㅡ, 0, None 인 경우
파이썬은 모든것이 객체이기 때문에 커스텀 객체도 참 거짓에 사용할 수 있다.
re.match는 일치하면 re.Match 객체를 반환, 일치하지 않을 경우 None을 반환하기 때문에 참거짓에 바로 쓸 수 있다.

2. 문자열이 알파뱃으로만 이루어진 문자열을 찾고 싶다면 내장함수 isalpha()를 사용할 수 있다.
   마찬가지로 문자열이 숫자로만 이루어진 경우 isdigit(), 알파뱃 또는 숫자로 이루어진 경우는 isalnum() 을 사용할 수 있다
"""
import re
from collections import Counter

def seperate(s):
    result = [s[i:i+2] for i in range(len(s) - 1) if re.match('^[a-z]{2}$', s[i:i+2])]
    return set(result), dict(Counter(result))


def solution(str1, str2):
    set1, dict1 = seperate(str1.lower())
    set2, dict2 = seperate(str2.lower())

    intersection = set1 & set2
    union = set1 | set2

    n1 = 0
    for el in intersection:
        n1 += min(dict1[el], dict2[el])

    n2 = 0
    for el in union:
        temp1 = dict1[el] if el in dict1 else 0
        temp2 = dict2[el] if el in dict2 else 0
        n2 += max(temp1, temp2)

    return int((n1 / n2) * 65536) if n2 > 0 else 65536

print(solution('Easdfasd',''))

print(re.match('^[a-z]{2}$', 'az'))
