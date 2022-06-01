# 생성 : set() 키워드 사용
# 파이썬의 집합에는 hashable 타입만 넣을 수 있다
# hashable type : int, float, decimal, bool, string, tuple, frozenset
listSet = set()
stringSet = set('string')

listSet.add([1, 2, 3])
# numberSet = set(123123) 이터러블한 객체만 set에 넣을 수 있음

# 교집합 &, 합집합 |, 차집합 -

# 요소 한개 추가 : add(element)
# 요소 여러개 추가 : update(list)
# 요소 제거 : remove(element)
