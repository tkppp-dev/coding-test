a = 1
b = 2

def testFunc():
  global a,b
  print(a, b)
  
testFunc()

# 람다 : 간단한 익명함수
lamdaFunc = lambda a, b: a+b

isOverflow = lambda x, y: x< 0 or x > 5 or y < 0 or y > 5

print(isOverflow(-1, 1))