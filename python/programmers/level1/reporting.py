# https://programmers.co.kr/learn/courses/30/lessons/92334?language=python3
# 시작시간 9:02
# 끝난시간 9:54

"""
어떤 메소드를 이용해 풀려고 할때 시간복잡도를 계산해보고 하자

index 메소드는 O(n)

"""

def solution(id_list, report, k):
    answer = [0] * len(id_list)
    report_dict = {_id: 0 for _id in id_list}
    report_set = set(report)

    for r in report_set:
        reported = r.split(' ')[1]
        report_dict[reported] += 1

    for r in report_set:
        reporter, reported = r.split(' ')
        if report_dict[reported] >= k:
            answer[id_list.index(reporter)] += 1

    return answer


solution(["muzi", "frodo", "apeach", "neo"], ["muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"], 2)
