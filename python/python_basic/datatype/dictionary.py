# dictionary == Map

# 요소 추가
dict1 = {}
dict1[1] = '1'
dict1['2'] = '2'
print(dict1)

# dictionary 메소드

# keys() : 딕셔너리 key들의 dict_keys 객체 반환
# 순회 용도로 사용하는 것이 아니라면 list(dict_keys) 로 변환해서 써야함
dictKeys = dict1.keys()
print(dictKeys)

# values() : 딕셔너리 value들의 dict_values 객체 반환
# items() : 딕셔너리 key,value쌍들의 dict_items 객체 반환

# get(key) : 존재하지 않는 키를 넘겨도 에러 발생하지 않고 None 반환

# in 연산자를 통해 key가 존재하는지 확인 가능