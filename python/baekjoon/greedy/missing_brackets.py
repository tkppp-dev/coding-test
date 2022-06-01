expression = input().split('-')

def calc(str):
    result = 0
    for num in str.split('+'):
        result += int(num)
    return result

answer = calc(expression[0])
for expr in expression[1:]:
    answer -= calc(expr)

print(answer)
