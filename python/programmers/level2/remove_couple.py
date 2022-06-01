"""
https://programmers.co.kr/learn/courses/30/lessons/12973

괄호 체크할때 스택을 써서 판별하는 것 처럼
두개의 쌍을 체크해서 제거해야 하는 문제는 스택을 사용한다.
문자열에서 붙어있는 두개의 짝만 체크해서 없애는 이런 유형은 스택을 고려해야 함
"""

def solution(s):
    stack = []
    for c in s:
        if len(stack) == 0:
            stack.append(c)
        else:
            if c == stack[-1]:
                stack.pop()
            else:
                stack.append(c)

    return 0 if len(stack) else 1

