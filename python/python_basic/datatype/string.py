# 숫자를 문자열로
intToStr = str(123)
print(intToStr)

# 문자열을 숫자로
strToInt = int("123")
print(strToInt)

# 문자열 합치기 : + or seperator.join(list: String)
head = "head"
tail = "tail"
concat1 = head + tail
print(concat1)
concat2 = ''.join([head, tail])
print(concat2)

# 문자열 인덱싱 : -idx는 뒤에서부터 센다, 즉 -1은 맨 뒤의 문자
# 문자열 자르기 : 슬라이싱의 마지막 인덱스는 포함하지 않는다
willSliced = 'Hello, Python'
sliced = willSliced[0:5]
print(sliced)

# 포함된 문자 개수 세기 : count
countedStr = 'aaaabbwdsa'
print(countedStr.count('c'))

# 문자열 처음 인덱스 찾기 : find, index
# index는 없는 문자열일 경우 에러를 발생
foundStr = 'asdfasdf'
print(foundStr.find('dfa'))

# 공백 지우기 : lstrip, rstrip, strip
# 문자열 바꾸기 : replace(oldStr, newStr)
# 문자열 나누기 : split(seperator)
foo = '1 2 3'
one, two = foo.split(' ')

# 문자열 형식 지정 : fstring -> str() 보다 편함
a1 = 123
l1 = [1,2,3]
print(f'a1 = {a1}')
print(f'l1 = {l1}')