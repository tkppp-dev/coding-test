"""
https://programmers.co.kr/learn/courses/30/lessons/42888

오랜만에 완벽하게 접근하고 풀어냈다 아주 칭찬해

다만 중간에 불필요한 코드들이 존재하긴함(틀린건 아니지만 없이 했어도 됨)
"""

def optimized_solution(record):
    user_dict = {}
    for log in record:
        temp = log.split(' ')
        cmd, uid, name = temp if len(temp) == 3 else (temp[0], temp[1], '')

        if cmd in ['Enter', 'Change']:
            user_dict[uid] = name

    answer = []
    for log in record:
        temp = log.split(' ')
        cmd, uid = temp[:2]

        if cmd == 'Enter':
            answer.append(f'{user_dict[uid]}님이 들어왔습니다.')
        elif cmd == 'Leave':
            answer.append(f'{user_dict[uid]}님이 나갔습니다.')

    return answer


def solution(record):
    logs = []
    user_dict = {}

    for log in record:
        temp = log.split(' ')
        cmd, uid, name = temp if len(temp) == 3 else (temp[0], temp[1], '')

        if cmd in ['Enter', 'Change']:
            user_dict[uid] = name

        if cmd == 'Enter':
            logs.append((uid, cmd))
        elif cmd == 'Leave':
            logs.append((uid, cmd))

    answer = []
    for i in range(len(logs)):
        uid, cmd = logs[i]

        if cmd == 'Enter':
            answer.append(f'{user_dict[uid]}님이 들어왔습니다.')
        else:
            answer.append(f'{user_dict[uid]}님이 나갔습니다.')

    return answer

print(optimized_solution(["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]	))
