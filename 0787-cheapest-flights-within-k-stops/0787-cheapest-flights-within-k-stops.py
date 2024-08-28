import heapq
class Solution(object):
    def findCheapestPrice(self, n, flights, src, dst, k):
        """
        :type n: int
        :type flights: List[List[int]]
        :type src: int
        :type dst: int
        :type k: int
        :rtype: int
        """
        graph = [[float('inf')]*n for i in range(n)]


        for i,j,w in flights:
            graph[i][j] = w

        pq = [(0,src,0)]
        vis = [False] * (n+1)

        res = [float('inf')] * (n+1)
        res[src] = 0
        stp = [float('inf')] * (n+1)

        stp[src] = 0

        # print(graph)

        while pq:
            # print(pq, res)
            currDist, curr, hops = heapq.heappop(pq)


            if( hops == k+1):
                continue


            for i in range(n):
                if graph[curr][i] == float('inf') or (vis[i]):
                    continue

                # print('hvjhklhvg', (graph[curr][i] + currDist <= res[i]))
                if graph[curr][i] + currDist <= res[i]:
                    res[i] = graph[curr][i] + currDist
                    stp[i] = hops+1
                    heapq.heappush(pq,(graph[curr][i] + currDist, i , hops+1))

                elif hops+1 < stp[i]:
                    stp[i] = hops +1
                    heapq.heappush(pq,(graph[curr][i] + currDist, i , hops+1))

   
                  
                
        print(res,stp)
        return -1 if res[dst] == float('inf') else res[dst]

        
        