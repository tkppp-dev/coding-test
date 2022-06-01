"""
https://programmers.co.kr/learn/courses/30/lessons/77485
"""


def swap(matrix, p1, p2):
    temp = matrix[p1[0]][p1[1]]
    matrix[p1[0]][p1[1]] = matrix[p2[0]][p2[1]]
    matrix[p2[0]][p2[1]] = temp

def solution(rows, columns, queries):
    answer = []
    matrix = []
    for i in range(columns):
        matrix.append([i * rows + j + 1 for j in range(rows)])

    for query in queries:
        y1, x1, y2, x2 = query
        min_num = int(1e9)

        for y in range(y1 - 1, y2 - 1):
            min_num = min(min_num, matrix[y][x1 - 1])
            swap(matrix, (y, x1 - 1), (y + 1, x1 - 1))

        for x in range(x1 - 1, x2 - 1):
            min_num = min(min_num, matrix[y2 - 1][x])
            swap(matrix, (y2 - 1, x), (y2 - 1, x + 1))

        for y in range(y2 - 1, y1 - 1, -1):
            min_num = min(min_num, matrix[y][x2 - 1])
            swap(matrix, (y, x2 - 1), (y - 1, x2 - 1))

        for x in range(x2 - 1, x1, -1):
            min_num = min(min_num, matrix[y1 - 1][x])
            swap(matrix, (y1 - 1, x), (y1 - 1, x - 1))

        min_num = min(min_num, matrix[y1 - 1][x1 + 1])

        answer.append(min_num)

    return answer

solution(6, 6, [[2,2,5,4],[3,3,6,6],[5,1,6,3]]	)
