"""
https://programmers.co.kr/learn/courses/30/lessons/17682

문자열 패턴을 나눌려고 하는데 있을수도 있고 없을 수도 있는 경우 : ? 사용
() 를 통해 그룹을 지정하면 find 시 묶여서 나온다

생각보다 findall 시 성능이 좋지 않다.
효율성 테스트가 있는 경우 주의 필요
"""
from re import *

def sol1(dart_result):
    pattern = compile('(\d+)([SDT])([*#]?)')
    cmds = pattern.findall(dart_result)
    answer = []

    bonus_dict = {'S': 1, 'D': 2, 'T': 3}
    opt_dict = {'*': 2, '#': -1, '': 1}
    for i in range(len(cmds)):
        score = int(cmds[i][0])
        answer.append(score ** bonus_dict[cmds[i][1]] * opt_dict[cmds[i][2]])
        if i > 0 and cmds[i][2] == '*':
            answer[i-1] *= 2

    return sum(answer)


def solution(dart_result):
    temp = dart_result.replace('10', 'X')
    result = []
    answer = []

    for idx, c in enumerate(temp):
        result.append(c)
        if c in 'SDT':
            if idx + 1 == len(temp) or temp[idx + 1] in '0123456789X':
                result.append('N')

    bonus_dict = {'S': 1, 'D': 2, 'T': 3}
    opt_dict = {'*': 2, '#': -1, 'N': 1}
    idx = 0

    for i in range(0, len(result), 3):
        score, bonus, opt = result[i:i + 3]
        score = 10 if score == 'X' else int(score)
        score = score ** bonus_dict[bonus] * opt_dict[opt]

        if opt == '*' and idx - 1 >= 0:
            answer[idx - 1] *= 2
        idx += 1
        answer.append(score)

    return sum(answer)


print(sol1('1S2D*3T'))
