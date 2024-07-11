class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        HashMap<Character,Integer> win=new HashMap<>();
        for(char c:t.toCharArray()){
        map.put(c,map.getOrDefault(c,0)+1);
        win.put(c,0);}
        int[] a=new int[3];
        a[0]=-1;
        int l=0,r=0,d=0,req=win.size();
        while(r<s.length())
        {
            
            if(map.containsKey(s.charAt(r)))
            {
                win.put(s.charAt(r),(win.get(s.charAt(r))+1));
                if(win.get(s.charAt(r)).intValue()==map.get(s.charAt(r)).intValue()){
                d++;
                }
            }
            while(l<=r&&d==req){
                if(a[0]==-1||(r-l+1)<a[0])
                {
                    a[0]=r-l+1;
                    a[1]=l;
                    a[2]=r;
                }
                if(map.containsKey(s.charAt(l)))
                {
                    win.put(s.charAt(l),win.get(s.charAt(l))-1);
                    if(win.get(s.charAt(l)).intValue()<map.get(s.charAt(l)).intValue())
                    {
                        d--;
                    }
                }
                l++;
            }
            r++;
        }
        return a[0]==-1?"":s.substring(a[1],a[2]+1);

    }
}