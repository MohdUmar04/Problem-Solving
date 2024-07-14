class Solution {
    public String addBinary(String a, String b) {
        a=(new StringBuilder(a).reverse()).toString();
        b=(new StringBuilder(b).reverse()).toString();
        int c=0,i=0,j=0;
        int x,y,s;
        StringBuilder ans=new StringBuilder();
        while(i<a.length()||j<b.length()||c==1)
        {
            x=i>=a.length()?0:a.charAt(i)-'0';
            y=j>=b.length()?0:b.charAt(j)-'0';
            s=x+y+c;
            if(s<=1)
            {
                ans.append(s);
                c=0;
            }
            if(s==2)
            {
                ans.append(0);
                c=1;
            }
            if(s==3)
            {
                ans.append(1);
                c=1;
            }
            i++;
            j++;
        }
        ans=ans.reverse();
        return ans.toString();
    }
}