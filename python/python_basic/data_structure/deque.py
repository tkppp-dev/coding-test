from collections import deque

a = [1,2,3,4,5]
dq = deque(a)

dq.rotate(1)
print(dq)

# 리스트와 다른점
# popleft, appendleft를 지원
# rotate 메소드로 회전을 쉽게 구현할 수 있음