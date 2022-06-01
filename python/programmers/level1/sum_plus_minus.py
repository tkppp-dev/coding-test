"""
https://programmers.co.kr/learn/courses/30/lessons/76501

Sol1.
    sum 함수를 이용한 짧은 풀이 가능
    sum 의 인자는 이터러블한 객체이므로 for 내포로 이터러블한 객체를 만들고 더해줄 수 있음
"""

def sol1(absolutes, signs):
    return sum(absolutes[i] if signs[i] else -absolutes[i] for i in range(len(absolutes)))

def solution(absolutes, signs):
    answer = 0
    for i in range(len(absolutes)):
        if signs[i]:
            answer += absolutes[i]
        else:
            answer -= absolutes[i]
    return answer
