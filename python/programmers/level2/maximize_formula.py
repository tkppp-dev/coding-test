"""
https://programmers.co.kr/learn/courses/30/lessons/67257

eval() : 식을 전달했을때 그 결과를 반환

"""
import itertools

def solution(expression):
    priorities = itertools.permutations(['+', '-', '*'], 3)
    answer = 0
    for p1, p2, p3 in priorities:
        temp_result = []
        for expr in expression.split(p3):
            temp = expr.split(p2)
            temp_result.append(list(map(lambda e: str(eval(e)), temp)))

        last_expr = []
        for temp in temp_result:
            last_expr.append(str(eval(p2.join(temp))))
        answer = max(answer, abs(eval(p3.join(last_expr))))

    return answer


solution("100-200*300-500+20")
