# itertools
from itertools import *
from operator import itemgetter

# 그룹핑 : groupby
data = [
    {'name': '이민서', 'blood': 'O'},
    {'name': '이영순', 'blood': 'B'},
    {'name': '이상호', 'blood': 'AB'},
    {'name': '김지민', 'blood': 'B'},
    {'name': '최상현', 'blood': 'AB'},
    {'name': '김지아', 'blood': 'A'},
    {'name': '손우진', 'blood': 'A'},
    {'name': '박은주', 'blood': 'A'}
]

group_raw = groupby(data, key=itemgetter('blood'))
group = {}

for key, group_data in group_raw:
    group[key] = list(group_data)
print(group)

# 순열의 경우의 수
data2 = [1, 2, 3, 4, 5]

print(list(permutations(data2, 2)))

# 조합의 경우의 수
print(list(combinations(data2, 2)))
