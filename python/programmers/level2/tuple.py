"""
https://programmers.co.kr/learn/courses/30/lessons/64065
"""

import re
from collections import Counter

def solution(s):
    count = Counter(re.findall('[0-9]+', s))
    return [int(x[0]) for x in count.most_common()]


print(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"))
