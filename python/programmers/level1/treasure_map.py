"""
https://programmers.co.kr/learn/courses/30/lessons/17681
"""

def sol1(n, arr1, arr2):
    answer = []

    for i in range(n):
        result = bin(arr1[i] | arr2[i])[2:]
        result = '0' * (n - len(result)) + result
        result = result.replace('1', '#')
        result = result.replace('0', ' ')
        answer.append(result)

    return answer


def solution(n, arr1, arr2):
    answer = []
    for i in range(n):
        temp = ''
        temp1 = bin(arr1[i])[2:]
        temp2 = bin(arr2[i])[2:]

        while len(temp1) < 5:
            temp1 = '0' + temp1

        while len(temp2) < 5:
            temp2 = '0' + temp2

        for j in range(n):
            if temp1[j] == '1' or temp2[j] == '1':
                temp += '#'
            else:
                temp += ' '
        answer.append(temp)

    return answer

foo = 20
print(sol1(5, [9, 20, 28, 18, 11],[30, 1, 21, 17, 28]))
