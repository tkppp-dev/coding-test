from spanning_tree import kruskal

if __name__ == '__main__':
    # n : 집의 수, m : 간선의 개수
    n, m = map(int, input().split())
    edges = []
    parent = [i for i in range(0, n + 1)]

    for _ in range(m):
        v1, v2, cost = map(int, input().split())
        edges.append((cost, v1, v2))

    result, contain_edges = kruskal(edges, parent)
    print(result - contain_edges[-1][0])

