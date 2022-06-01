def calc_dist(p1, p2):
    return abs(p1[0] - p2[0]) + abs(p1[1] - p2[1])

def left_move(answer, num):
    answer += 'L'
    return answer, num

def right_move(answer, num):
    answer += 'R'
    return answer, num

def solution(numbers, hand):
    answer = ''
    position = {1: (0, 0), 4: (0, 1), 7: (0, 2), '*': (0, 3),
                2: (1, 0), 5: (1, 1), 8: (1, 2), 0: (1, 3),
                3: (2, 0), 6: (2, 1), 9: (2, 2), '#': (2, 3)}
    left = {1, 4, 7, '*'}
    right = {3, 6, 9, '#'}
    l_thumb = '*'
    r_thumb = '#'
    for num in numbers:
        if num in left:
            answer, l_thumb = left_move(answer, num)
        elif num in right:
            answer, r_thumb = right_move(answer, num)
        else:
            dist_l = calc_dist(position[l_thumb], position[num])
            dist_r = calc_dist(position[r_thumb], position[num])
            if dist_l < dist_r:
                answer, l_thumb = left_move(answer, num)
            elif dist_l > dist_r:
                answer, r_thumb = right_move(answer, num)
            else:
                if hand == 'left':
                    answer, l_thumb = left_move(answer, num)
                else:
                    answer, r_thumb = right_move(answer, num)

    return answer


print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], 'right'))
