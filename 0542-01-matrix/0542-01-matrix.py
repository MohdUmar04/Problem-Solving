from collections import deque

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        rows, cols = len(mat), len(mat[0])
        # Initialize the result matrix with a large number (infinity)
        result = [[float('inf')] * cols for _ in range(rows)]
        queue = deque()

        # Initialize queue with all 0's positions and set their distance to 0
        for i in range(rows):
            for j in range(cols):
                if mat[i][j] == 0:
                    queue.append((i, j))
                    result[i][j] = 0

        # Directions for moving in 4 possible ways (up, down, left, right)
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        # Perform BFS
        while queue:
            i, j = queue.popleft()

            for direction in directions:
                ni, nj = i + direction[0], j + direction[1]
                
                if 0 <= ni < rows and 0 <= nj < cols:
                    # If the current path gives a shorter distance, update and add to queue
                    if result[ni][nj] > result[i][j] + 1:
                        result[ni][nj] = result[i][j] + 1
                        queue.append((ni, nj))

        return result
