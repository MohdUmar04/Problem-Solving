class Solution {
    public int countConsistentStrings(String allowed, String[] s) {
        
        int[] f=new int[26];
        String str="";
        int ctr=0,f1=0,i,j;
        for(i=0;i<26;i++)
        {
            f[i]=0;
        }
        for(i=0;i<allowed.length();i++)
        {
            f[(allowed.charAt(i)-97)]++;
        }
        for(i=0;i<s.length;i++)
        {
            str=s[i];
            f1=0;
            for(j=0;j<str.length();j++)
            {
                char c=str.charAt(j);
                if(f[c-97]==0){
                    f1=1;
                    break;
                }
            }
            if(f1==0)
                ctr++;
        }
        return ctr;
        
    }
}