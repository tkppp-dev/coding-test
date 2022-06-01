from re import sub

"""
https://programmers.co.kr/learn/courses/30/lessons/72410
전형적인 정규식 문제

정규식 https://hamait.tistory.com/342
"""

def solution(new_id):
    answer = new_id.lower()  # 1
    answer = sub('[^a-z0-9_.-]', '', answer)    # 2
    answer = sub('\.{2,}', '.', answer)     # 3
    answer = sub('^./|./$', '', answer)     # 4
    answer = 'a' if len(answer) == 0 else answer    # 5
    # 6
    if len(answer) > 15:
        if answer[14] == '.':
            answer = answer[:14]
        else:
            answer = answer[:15]
    # 7
    while len(answer) < 3:
        answer += answer[-1]

    return answer

print(solution("abcdefghijklmn.p"))
