"""
https://programmers.co.kr/learn/courses/30/lessons/1845
"""

def solution(nums):
    k = len(nums) // 2
    kind = set(nums)

    return len(kind) if len(kind) < k else k