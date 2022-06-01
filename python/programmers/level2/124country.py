"""

"""


def solution(n):
    answer = ''
    num_dict = {0: '4', 1: '1', 2: '2'}
    while n > 0:
        answer = num_dict[n % 3] + answer
        if n % 3 == 0:
            n = (n - 1) // 3
        else:
            n //= 3

    return answer


for i in range(1, 21):
    print(i, solution(i))
