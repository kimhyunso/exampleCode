def dfs(graph, start):
    visited = set()
    route = []
    stack = [start]

    while stack:
        vertex = stack.pop()
        if vertex not in visited:
            route.append(vertex)
            visited.add(vertex)

            stack.extend(reversed(graph[vertex]))

    return route


graph = {
    0 : [1, 2, 4],
    1 : [0, 3],
    2 : [0],
    3 : [1, 5],
    4 : [0],
    5 : [3],
}

route = dfs(graph, 0)

print(route )
