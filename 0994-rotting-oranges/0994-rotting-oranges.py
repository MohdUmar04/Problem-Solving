from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        que = deque()
        fresh, result = 0, -1

        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 2:
                    que.append([i,j])
                if grid[i][j] == 1:
                    fresh += 1
        
        if(len(que) == 0 and fresh == 0):
            return 0

        while(len(que) > 0) :
            
            size = len(que)
            while(size > 0):
                print(que)
                temp = que.popleft()
                i, j = temp[0], temp[1]

                # print(i,j)
                
                if( i-1 > -1 and grid[i-1][j] == 1):
                    grid[i-1][j] = 2
                    que.append([i-1, j])

                if( j-1 > -1 and grid[i][j-1] == 1):
                    grid[i][j-1] = 2
                    que.append([i, j-1])

                if( i+1 < len(grid) and grid[i+1][j] == 1):
                    grid[i+1][j] = 2
                    que.append([i+1, j])

                if( j+1 < len(grid[0]) and grid[i][j+1] == 1):
                    grid[i][j+1] = 2
                    que.append([i, j+1])

                size -= 1

            fresh -= len(que)

            result += 1
            

        return result if fresh == 0 else -1

        
        