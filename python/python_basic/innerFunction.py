# 절대값 : abs()
# 최대갑 : max()
# 최소값 : min()
# 제곱 : pow()
# 반올림 : round()
# 모듈러 연산 : divmd(a,b) -> 몫과 나머지를 튜플로 반환

# 필터링 : filter(조건함수, 필터링한 이터러블 객체) -> 필터링 객체를 반환하기 때문에 사용할려면 리스트로 변환 필요
filtered = [1,2,3,4,5,6,7,8]
def isEven(n): return n % 2 == 0

print(list(filter(isEven, filtered)))
print(list(filter(lambda n: n%2==0, filtered)))

# 매핑 : map(조건함수, 매핑할 이터러블 객체)
mapped = [1,2,3,4]
print(list(map(lambda el: el*2, mapped)))

# 전체합 : sum(list or tuple) == fold
print(sum(mapped))

# 주소값 : id(obj)
# 타입 변환 : str(), int()
# 요소 개수 : len() == size

# 정렬 : sorted
# sorted(list, keyOpt ,reversedOpt)으로 정렬 가능
# 중첩 리스트, 튜블에서 기준 잡아 정렬하기
# 다중 기준 => 기준이 되는 값을 튜플로 내보내면 됨. -를 붙힐시 역순

outer = [(1,'aa'), (5, 'bb'), (2, 'cc'), (2, 'dd'), (4, 'ee')]

print(sorted(outer, key = lambda el: -el[0]))
print(sorted(outer, key = lambda el: (el[0], el[1])))

# ascii(unicode) 변환
# chr(number) : 숫자를 유니코드(아스키) 문자롤 변환
# ord(char) : 문자를 유니코드(아스키코드)로 변환

# zip(iterable)