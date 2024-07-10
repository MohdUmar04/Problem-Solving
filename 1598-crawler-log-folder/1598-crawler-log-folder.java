class Solution {
    public int minOperations(String[] logs) {
        int c=0;
        for(String s : logs) {
            if(s.equals("./") || (c == 0 && s.equals("../")))
                continue;
            else if(s.equals("../"))
                c--;
            else
                c++;
        }
        return c;
    }
}