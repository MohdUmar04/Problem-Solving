import heapq
class Solution(object):
    def frequencySort(self, s):
        """
        :type s: str
        :rtype: str
        """
        class maxheap:
            def __init__(self, n, m):
                self.key = n
                self.val = m


            def __lt__(self, that):
                return self.val > that.val

        
        d = {}
        pq =[]

        for c in s:
            if c in d:
                d[c] += 1
            else:
                d[c] = 1

        for i,j in d.items():
            heapq.heappush(pq,maxheap(i,j))


        s = ""

        while pq:
            s += ''.join([pq[0].key * pq[0].val]) 
            heapq.heappop(pq)

        return s
            
        
