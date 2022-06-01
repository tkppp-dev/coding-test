"""
https://programmers.co.kr/learn/courses/30/lessons/60058
문제를 이해하기가 빡셌으나 문제에서 시키는대로 하면 되는 문제
문제 이해가 잘 안되면 입출력 예제 설명을 보자!
"""


def is_correct_string(s):
    stack = []

    for c in s:
        if len(stack):
            if stack[-1] == '(' and c == ')':
                stack.pop()
            else:
                stack.append(c)
        else:
            stack.append(c)

    return True if not len(stack) else False


def divide_string(s):
    _open = 0
    close = 0

    i = 0
    while True:
        if i == len(s):
            break

        if s[i] == '(':
            _open += 1
        else:
            close += 1

        if _open == close:
            break
        else:
            i += 1

    return s[:i + 1], s[i + 1:]


def recursive(s):
    if len(s):
        u, v = divide_string(s)
        print(f'u: {u}, v: {v}')
        if is_correct_string(u):
            return u + recursive(v)
        else:
            answer = '('
            answer += recursive(v) + ')'

            temp = u[1: -1] if len(u) else ''
            temp = ''.join(map(lambda c: '(' if c == ')' else ')', temp))
            return answer + temp
    else:
        return ''


def solution(p):
    return recursive(p)


print(solution("()))((()"))
