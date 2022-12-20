import java.util.*;
class ReorganizeString {
    public String reorganizeString(String s) {
        PriorityQueue<Map.Entry<Character,Integer>> maxheap=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        Map<Character,Integer> map=new HashMap<>();
        int i;
        for(i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for( Map.Entry<Character,Integer> z:map.entrySet())
        {
            maxheap.add(z);
        }
        Map.Entry<Character,Integer> p;
        Map.Entry<Character,Integer> q;
        s="";
        while(maxheap.size()>1)
        {
            p=maxheap.poll();
            q=maxheap.poll();
            s=s+p.getKey();
            s=s+q.getKey();
            q.setValue(q.getValue()-1);
            p.setValue(p.getValue()-1);
            if(p.getValue()>0)
            maxheap.add(p);
            if(q.getValue()>0)
            maxheap.add(q);
        }
        if(maxheap.isEmpty()==true)
        return s;
        else
        {
            p=maxheap.poll();
            if(p.getValue()==1){
            s=s+p.getKey();
            return s;
            }
            else
            return ""; 
        }
    }
}