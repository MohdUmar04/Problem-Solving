import java.util.*;
class SortCharactersByFrequency {
    public String frequencySort(String s) {
        PriorityQueue<Map.Entry<Character,Integer>> maxheap=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        Map<Character,Integer> map=new HashMap<>();
        for(int z=0;z<s.length();z++)
        map.put(s.charAt(z),map.getOrDefault(s.charAt(z),0)+1);
        for(Map.Entry<Character,Integer> z : map.entrySet())
        maxheap.offer(z);
        System.out.println(maxheap);
        StringBuilder st=new StringBuilder();
        Map.Entry<Character,Integer> z;
        while(maxheap.size()!=0)
        {
            z=maxheap.poll();
            for(int i=0;i<z.getValue();i++)
            st.append(z.getKey());
        }
        return st.toString();
    }
}