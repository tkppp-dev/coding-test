from copy import deepcopy

# 초기값 설정 :
listInit1 = [0 for i in range(0,10)]
listInit2 = [i for i in range(0, 10)]
listInit3 = [0] * 10

# 리스트의 길이 : len(list) 사용 필요
# 요소 추가 : append, insert
list = [1,2,3]
list.append(4)
list.insert(0, 0)
print(list)

# 정렬 : list.sort() -> 원본 배열 자체 정렬, sorted() -> 내장 함수
# 내림차순 정렬 : reverse 옵션 추가
sortedList = [1,4,5,3,6]
sortedList.sort(reverse=True)
print(sortedList)

# 뒤집기 : reverse
reversedList = [1,2,3]
reversedList.reverse()
print(reversedList)

# 요소 제거 : pop(), remove(idx)
# pop -> 맨뒤 제거, remove -> 원하는 인덱스의 요소 제거

# 슬라이싱으로 리스트 복사 -> 깊은 복사 안됨
# copy 모듈의 deepcopy 메소드 사용해야함
copyedList = [1,2,[1,4,5]]
temp = copyedList[:]
deepCopy = deepcopy(copyedList)
print(id(copyedList[2]), id(temp[2]))