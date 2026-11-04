"""
Graphs and Shortest Paths in Python.
Breadth-First Search (BFS), Depth-First Search (DFS), and Dijkstra's Shortest Path.

Author: CodeByTushu
Website: https://codebytushu.com
"""

from collections import deque
import heapq

def bfs(graph, start_node):
    visited = set([start_node])
    queue = deque([start_node])
    order = []
    
    while queue:
        node = queue.popleft()
        order.append(node)
        for neighbor in graph.get(node, []):
            if neighbor not in visited:
                visited.add(neighbor)
                queue.append(neighbor)
    return order

def dijkstra(graph, start_node):
    # Min-heap priority queue
    distances = {node: float('inf') for node in graph}
    distances[start_node] = 0
    pq = [(0, start_node)]
    
    while pq:
        curr_dist, u = heapq.heappop(pq)
        
        if curr_dist > distances[u]:
            continue
            
        for v, weight in graph.get(u, []):
            if curr_dist + weight < distances[v]:
                distances[v] = curr_dist + weight
                heapq.heappush(pq, (distances[v], v))
                
    return distances

if __name__ == "__main__":
    g = {
        0: [(1, 4), (2, 1)],
        1: [(3, 1)],
        2: [(1, 2), (3, 5)],
        3: [(4, 3)],
        4: []
    }
    print("Dijkstra distances from 0:", dijkstra(g, 0))
