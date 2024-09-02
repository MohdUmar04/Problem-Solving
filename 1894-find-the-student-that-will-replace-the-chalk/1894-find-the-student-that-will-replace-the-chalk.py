class Solution(object):
    def chalkReplacer(self, chalk, k):
        """
        :type chalk: List[int]
        :type k: int
        :rtype: int
        """
        s = sum(chalk)
        # print(s)
        s = k%s
        i = 0
        while(s > 0):
            # print(s)
            if(s < chalk[i]):
                break
            s -= chalk[i]
            i += 1
        return i
        