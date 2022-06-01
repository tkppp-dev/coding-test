"""
시작시간 1:53
끝난시간 2:12

1. 파이썬에서 빈 배열은 false 이기 때문에 len(list) > 0) 대신 if list 해도 댐
2. 2차원 배열에서 x축 별로 원소 분리하는 법 : zip
    zip(*2차원 배열) 하면 x축 원소끼리 모아짐
"""


def map_func(group):
    temp = list(filter(lambda el: el > 0, group))
    temp.reverse()
    return temp

def solution(board, moves):
    answer = 0
    n = len(board)
    board_dict = {i: [] for i in range(1, n + 1)}
    filter_board = list(map(lambda group: map_func(group), zip(*board)))

    print(filter_board)
    for x in range(n):
        for y in range(n - 1, -1, -1):
            if board[y][x] != 0:
                board_dict[x + 1].append(board[y][x])

    stack = []
    for move in moves:
        if board_dict[move]:
            pop = board_dict[move].pop()
            print(pop, 0 if not stack else stack[-1])
            if not stack or stack[-1] != pop:
                stack.append(pop)
            else:
                stack.pop()
                answer += 2

    return answer


test = []

print(solution([[0, 0, 0, 0, 0], [0, 0, 1, 0, 3], [0, 2, 5, 0, 1], [4, 2, 4, 4, 2], [3, 5, 1, 3, 1]],
               [1, 5, 3, 5, 1, 2, 1, 4]))
