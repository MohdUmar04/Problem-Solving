class Solution {
    public String minstr(String[] strs){
        int min=Integer.MAX_VALUE;
        String st="";
        for(String s:strs){
            if(s.length()<min)
            {
                min=s.length();
                st=s;
            }
        }
        return st;
    }
    public String longestCommonPrefix(String[] strs) {
        String s=minstr(strs);
        int f;
        while(s.length()!=0){
            f=0;
            for(String str:strs){
                if(!(str.substring(0,s.length()).equals(s)))
                f=1;
            }
            if(f==0)
            return s;
            else
            s=s.substring(0,s.length()-1);
        }
        return "";
    }
}