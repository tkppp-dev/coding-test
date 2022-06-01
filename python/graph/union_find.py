def find_parent(parent, x):
    if parent[x] == x:
        return x
    else:
        return find_parent(parent, parent[x])


def union(parent, a, b):
    a_parent = find_parent(parent, a)
    b_parent = find_parent(parent, b)

    if a < b:
        parent[b_parent] = a_parent
    else:
        parent[a_parent] = b_parent


parents = [i for i in range(0, 10)]

union(parents, 1, 2)
print(parents)

union(parents, 2, 3)
print(parents)

union(parents, 2, 4)
print(parents)
