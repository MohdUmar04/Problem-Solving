class Solution {
    public boolean isPalindrome(int x) {
        int i;
        String s=x+"";
        for(i=0;i<s.length()/2;i++)
        {
            s=s.replace(s.charAt(i),s.charAt(s.length()-(i+1)));
        }
            
        if(s.compareTo(x+"")==0)
            return true;
        else
            return false;
    }
}