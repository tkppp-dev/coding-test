# 신장 트리 : 그래프에서 사이클이 존재하지 않는 부분 그래프
# 최소 신장 트리(MST) : 신장 트리 중 간선의 가중치 합이 제일 작은 신장 트리
# Kruskal Algorithm : 최소 신장 트리를 만드는 알고리즘
#   1. 간선 정보를 가중치 기준으로 오름차순 정력
#   2. 가중치가 작은 간선부터 추가하되 사이클이 존재하지 않는 경우만 추가
#       2-1. 사이클 판별은 union-find

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union(parent, a, b):
    a_parent = find_parent(parent, a)
    b_parent = find_parent(parent, b)

    if a_parent < b_parent:
        parent[b_parent] = a_parent
    else:
        parent[a_parent] = b_parent


def kruskal(edges, parents):
    result = 0
    contain_edges = []
    edges.sort()
    for edge in edges:
        weight, v1, v2 = edge
        if find_parent(parents, v1) == find_parent(parents, v2):
            continue
        else:
            result += weight
            contain_edges.append(edge)
            union(parents, v1, v2)

    return result, contain_edges


def main():
    v, e = map(int, input().split())
    edges = []
    parents = [i for i in range(0, v + 1)]

    for _ in range(e):
        v1, v2, cost = map(int, input().split())
        edges.append((cost, v1, v2))

    result, contain_edges = kruskal(edges, parents)
    print(result, contain_edges)


if __name__ == '__main__':
    main()

